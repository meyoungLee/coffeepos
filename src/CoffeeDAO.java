
import java.util.ArrayList;



public interface CoffeeDAO {

	// 서버에 판매정보 저장
	public abstract int coffeeadd(CoffeeVO vo);

	// 이전 재고 업데이트
	public abstract int stockorder(StockVO vos);

	// 오늘 판매된 음료
	public abstract ArrayList<CoffeeVO> Getsellcount();

	// 모든 상품 목록들을 리턴
	public abstract ArrayList<CoffeeVO> GetAllSellList();
	
	// 서버에서 재고데이터 가져오기
	public abstract StockVO getstock();
	
	//재고를 받아서 오브젝트로 만들어준다
	public Object[][] makestocklistArr(StockVO lists);
	
	// 서버에서 재고데이터 가져오기
//	public abstract ArrayList<StockVO> getstock();
	
	

	
	
	
	
	
	
//	// ArrayList를 받아서 전체를 2차원 배열로 만들어주는 메소드
//	public abstract Object[][] makeArr(ArrayList<CoffeeVO> lists);
//
//	// 벡터를 받아서 판대량을 2차원 배열로 만들어주는 메소드
//	public abstract Object[][] makelistArr(ArrayList<CoffeeVO> lists);
//
//	// 스탁을 받아서 오브젝트로 만들어줌
//	public abstract Object[][] makestocklistArr(StockVO lists);

}

