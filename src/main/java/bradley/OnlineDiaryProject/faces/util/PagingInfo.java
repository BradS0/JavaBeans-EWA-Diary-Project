package bradley.OnlineDiaryProject.faces.util;

/**
 *
 * @author Bradley
 */
public class PagingInfo {
    private int batchSize = 5;
    private int firstItem = 0;
    private int itemCount = -1;
    
    /**
     *
     * @return
     */
    public int getBatchSize() {
        return batchSize;
    }
    
    /**
     *
     * @return
     */
    public int getItemCount() {
        return itemCount;
    }
    
    /**
     *
     * @param itemCount
     */
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
    
    /**
     *
     * @return
     */
    public int getFirstItem() {
        if (itemCount == -1) {
            throw new IllegalStateException("itemCount must be set before invoking getFirstItem");
        }
        if (firstItem >= itemCount) {
            if (itemCount == 0) {
                firstItem = 0;
            } else {
                int zeroBasedItemCount = itemCount - 1;
                double pageDouble = zeroBasedItemCount / batchSize;
                int page = (int) Math.floor(pageDouble);
                firstItem = page * batchSize;
            }
        }
        return firstItem;
    }
    
    /**
     *
     * @param firstItem
     */
    public void setFirstItem(int firstItem) {
        this.firstItem = firstItem;
    }
    
    /**
     *
     * @return
     */
    public int getLastItem() {
        getFirstItem();
        return firstItem + batchSize > itemCount ? itemCount : firstItem + batchSize;
    }
    
    /**
     *
     */
    public void nextPage() {
        getFirstItem();
        if (firstItem + batchSize < itemCount) {
            firstItem += batchSize;
        }
    }
    
    /**
     *
     */
    public void previousPage() {
        getFirstItem();
        firstItem -= batchSize;
        if (firstItem < 0) {
            firstItem = 0;
        }
    }
}
