package proxy;
import javax.servlet.http.HttpServletRequest;

import command.Receiver;
import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagination implements Proxy{
	
	private int pageNum, pageSize, blockSize,
			startRow, endRow, startPage, endPage,
			prevBlock, nextBlock, rowCount;
	private boolean existPrev, existNext;
	
	@Override
	public void carryOut(Object o) {
		System.out.println("페이지네이션 캐리아웃 내부");
		HttpServletRequest request = (HttpServletRequest)o;
		
		String _pageNum = request.getParameter("page_num");
		pageNum = (_pageNum == null) ? 1 : Integer.parseInt(_pageNum);
		System.out.println("Pagination안에 페이지넘버"+pageNum);
		
		String _pageSize = request.getParameter("page_size");
		pageSize = (_pageNum == null) ? 5 : Integer.parseInt(_pageSize);
		System.out.println("Pagination안에 페이지사이즈"+pageSize);
				
		rowCount = CustomerServiceImpl.getInstance().countCustomer(null);
		System.out.println("전체카운트::::"+rowCount);
		
		int pageCount = rowCount / pageSize;//페이지
		System.out.println("전체 페이지수:"+pageCount);
		
		int startRow = (pageNum -1) * pageSize+1;
		System.out.println("StartRow"+startRow);
		
		endRow =(rowCount > pageNum * pageSize)? pageNum * pageSize : rowCount;
		System.out.println("endRow"+endRow);
		System.out.println("스타트로우는::::"+startRow);
		System.out.println("앤드로우::::"+endRow);
		
		
		
			
		/*String pageSize = request.getParameter("page_size");
		
				
		this.totalCount = CustomerServiceImpl.getInstance().countCustomer();*/
		
		
		
		
		
	}
}
