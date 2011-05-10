package tx;


public class DevTx
{
    // Tidy up 
    //   See HACK (BPTreeNode)
    // Block: Split "modified" into isWriteable and hasChanged
    
    // bin-test/bptree --track
    
    // Caching pages across actions sequences. e.g BPT root block.
    // Cache in transaction so forgettable?
    
    // ---- ---- ---- ----
    
    // [TxTDB:PATCH-UP]

    /*
     * Iterator tracking
     *   End transaction => close all open iterators.
     *   Need transaction - at least something to attach for tracking.
     *     ==> Add "transaction txn" to all RangeIndex operations.  Default null -> no transaction.
     *     OR
     *     ==> Add to B+Tree   .setTransaction(Transaction txn) 
     *   End transaction -> close block managers -> checking? 
     *   
     * Recycle DatasetGraphTx objects.  Setup - set PageView
     *   better setup.
     */

    /*
     * Layers:
     *   DatasetGraph
     *   Indexes
     *   Pages
     *   Blocks
     *   Storage = FileAccess (a sequence of blocks) 
     */
    
    /* 
     * Fast B+Tree creation: wrap an existsing BPTree with another that switches the block managers only.
     * Cache root block.
     * Setup
     *   Transaction start: grab alloc id.
     */
    
    // TDB 0.8.10 is rev 8718; TxTDB forked at 8731
}
