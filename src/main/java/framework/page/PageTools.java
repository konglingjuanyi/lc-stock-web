package framework.page;

import java.util.ArrayList;                                                                                                       
import java.util.List;                                                                                                            
                                                                                                                                  
public class PageTools<T> {                                                                                                       
	public PageTools() {                                                                                                          
		this.setPageSize(25);                                                                                                     
		this.setCurrPage(1);                                                                                                      
	}                                                                                                                             
                                                                                                                                  
	public PageTools(int _currPage, int _pageSize, int _totalCount) {                                                             
		this.setCurrPage(_currPage);                                                                                              
		this.setPageSize(_pageSize);                                                                                              
		this.setTotalCount(_totalCount);                                                                                          
	}                                                                                                                             
                                                                                                                                  
	private int pageSize;                                                                                                         
	private int totalPage;                                                                                                        
	private int currPage;                                                                                                         
	private int totalCount;                                                                                                       
	private List<T> models;                                                                                                       
                                                                                                                                  
	public int getPageSize() {                                                                                                    
		if(this.pageSize<=0)                                                                                                      
			return 25;                                                                                                            
		return pageSize;                                                                                                          
	}                                                                                                                             
                                                                                                                                  
	public void setPageSize(int pageSize) {                                                                                       
		this.pageSize = pageSize;                                                                                                 
	}                                                                                                                             
                                                                                                                                  
	public int getTotalPage() {                                                                                                   
		int tp = (int) Math.ceil(this.getTotalCount()                                                                             
				/ (double) this.getPageSize());                                                                                   
		this.totalPage = tp;                                                                                                      
		return totalPage;                                                                                                         
	}                                                                                                                             
                                                                                                                                  
	public int getCurrPage() {                                                                                                    
		if (currPage <= 0)                                                                                                        
			currPage = 1;                                                                                                         
		if (this.getTotalCount() <= 0) {                                                                                          
			currPage = 1;                                                                                                         
		}                                                                                                                         
		if (currPage > this.getTotalPage())                                                                                       
			currPage = this.getTotalPage();                                                                                       
		return currPage;                                                                                                          
	}                                                                                                                             
                                                                                                                                  
	public void setCurrPage(int currPage) {                                                                                       
		this.currPage = currPage;                                                                                                 
	}                                                                                                                             
                                                                                                                                  
	public int getTotalCount() {                                                                                                  
		if (this.totalCount < 0)                                                                                                  
			this.totalCount = 0;                                                                                                  
		return totalCount;                                                                                                        
	}                                                                                                                             
                                                                                                                                  
	public void setTotalCount(int totalCount) {                                                                                   
		this.totalCount = totalCount;                                                                                             
	}                                                                                                                             
                                                                                                                                  
	public List<T> getModels() {                                                                                                  
		return models;                                                                                                            
	}                                                                                                                             
                                                                                                                                  
	public void setModels(List<T> models) {                                                                                       
		this.models = models;                                                                                                     
	}                                                                                                                             
                                                                                                                                  
	public int prevPage() {                                                                                                       
		return this.getCurrPage() > 1 ? this.getCurrPage() - 1 : 1;                                                               
	}                                                                                                                             
                                                                                                                                  
	public int nextPage() {                                                                                                       
		return this.getCurrPage() < this.getTotalPage() ? this.getCurrPage() + 1                                                  
				: this.getTotalPage();                                                                                            
	}                                                                                                                             
                                                                                                                                  
	public boolean hasPrevPages() {                                                                                               
		return this.getCurrPage() > 1;                                                                                            
	}                                                                                                                             
                                                                                                                                  
	public boolean hasNextPages() {                                                                                               
		return this.getCurrPage() < this.getTotalPage();                                                                          
	}                                                                                                                             
                                                                                                                                  
	public int[] getPageNums(int count) {                                                                                         
		if (this.getTotalPage() < count)                                                                                          
			count = this.getTotalPage();                                                                                          
                                                                                                                                  
		int[] ary = new int[count];                                                                                               
                                                                                                                                  
		int c = (int) Math.ceil(count / 2.0);                                                                                     
		int start = 1;                                                                                                            
		int end = count;                                                                                                          
		if (this.getCurrPage() % 2 == 0) {                                                                                        
			start = this.getCurrPage() - c;                                                                                       
		} else {                                                                                                                  
			start = this.getCurrPage() - (c - 1);                                                                                 
		}                                                                                                                         
                                                                                                                                  
		end = start + count;                                                                                                      
                                                                                                                                  
		if (this.getCurrPage() == 1 || start <= 1) {                                                                              
			for (int i = 1; i <= count; i++) {                                                                                    
				ary[i - 1] = i;                                                                                                   
			}                                                                                                                     
		} else if (this.getCurrPage() == this.getTotalPage()                                                                      
				|| end >= this.getTotalPage()) {                                                                                  
			for (int i = count; i > 0; i--) {                                                                                     
				ary[count - i] = this.getTotalPage() - i + 1;                                                                     
			}                                                                                                                     
		} else {                                                                                                                  
			int y = 1;                                                                                                            
			for (int i = start; i < end; i++) {                                                                                   
				ary[y - 1] = i;                                                                                                   
				y++;                                                                                                              
			}                                                                                                                     
		}                                                                                                                         
		return ary;                                                                                                               
	}                                                                                                                             
	                                                                                                                              
	public int[] getPageNums(){                                                                                                   
		return this.getPageNums(10);                                                                                              
	}                                                                                                                             
                                                                                                                                  
	public List<T>getModelsByPage(){                                                                                              
		List<T> list=new ArrayList<T>();                                                                                          
		int start=(this.getCurrPage()-1)*this.getPageSize();                                                                      
		int end=start+this.getPageSize();                                                                                         
		if(this.getPageSize()>=this.getModels().size())                                                                           
			return this.getModels();                                                                                              
		if(end>this.getModels().size())                                                                                           
			end=this.getModels().size();                                                                                          
		for(int i=start;i<end;i++){                                                                                               
			list.add(this.getModels().get(i));                                                                                    
		}                                                                                                                         
		return list;                                                                                                              
	}                                                                                                                             
	/**                                                                                                                           
	 * @param args                                                                                                                
	 */                                                                                                                           
	public static void main(String[] args) {                                                                                      
		// TODO Auto-generated method stub                                                                                        
//		PageTools pt = new PageTools<Object>(13, 25, 50);                                                                         
//		int[] ary = pt.GetPageNums();                                                                                             
//		for (int i : ary) {                                                                                                       
//			System.out.println(i);                                                                                                
//		}                                                                                                                         
	}                                                                                                                             
}                                                                                                                                 
                                                                                                                                  