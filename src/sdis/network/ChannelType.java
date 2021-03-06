package sdis.network;

/**
 * Multicast Channel Type
 */
public enum ChannelType {

    /**
     * Multicast Control Channel
     */
    MC,

    /**
     * Multicast Data Backup Channel
     */
    MDB,

    /**
     * Multicast Data Restore Channel
     */
    MDR,

    /**
     * TCP Data Restore Channel
     */
    TDR,
}
