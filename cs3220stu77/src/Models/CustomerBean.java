package Models;

import java.util.ArrayList;
import java.util.List;

public class CustomerBean {

	
	
	List<CustomerEntry> entries;

	
    public CustomerBean()
    {
        entries = new ArrayList<CustomerEntry>();
    }

    public void setAddEntry( String dummy )
    {
    	CustomerEntry entry = new CustomerEntry();
        entries.add( entry );
    }

    public CustomerEntry getLastEntry()
    {
        return entries.get( entries.size() - 1 );
    }

    public List<CustomerEntry> getEntries()
    {
        return entries;
    }

    public void setEntries( List<CustomerEntry> entries )
    {
        this.entries = entries;
    }

}
