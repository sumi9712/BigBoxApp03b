package bigbox.db;
import bigbox.business.Store;

public interface StoreWriter {
	 boolean addStore(Store s);
	    boolean updateStore(Store s);
	    boolean deleteStore(String d);

}
