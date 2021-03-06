package sdis.protocol;

import sdis.BackupService;
import sdis.network.ChannelType;

/**
 * Delete file protocol
 */
public class DeleteFile implements BackupProtocol, Runnable {

    /**
     * File hash to be deleted
     */
    private final String fileHash;
    /**
     * Enhaced Version of DeleteFile
     */
    private boolean enhanced;

    /**
     * Constructor of DeleteFile
     *
     * @param fileHash file to be deleted
     */
    public DeleteFile(final String fileHash,boolean enhanced) {
        this.fileHash = fileHash;
        this.enhanced = enhanced;
    }

    /**
     * Run method of the get chunk
     */
    @Override
    public void run() {
        // Send delete file message
        byte[] message = getMessage();
        BackupService.getInstance().getChannelsHandler().sendMessage(message, ChannelType.MC);

        //System.out.println("Deleting a file from the backup service!");
    }

    /**
     * Get the delete file protocol message
     *
     * @return delete file protocol message
     */
    @Override
    public byte[] getMessage() {
        String header =
                BackupProtocol.DELETE_MESSAGE + " "
                        + (enhanced ? BackupProtocol.VERSION_ENHANCEMENT :BackupProtocol.VERSION) + " "
                        + BackupService.getInstance().getServerId() + " "
                        + fileHash + " "
                        + BackupProtocol.CRLF
                        + BackupProtocol.CRLF;
        return header.getBytes();
    }
}
