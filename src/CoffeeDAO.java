
import java.util.ArrayList;



public interface CoffeeDAO {

	// ������ �Ǹ����� ����
	public abstract int coffeeadd(CoffeeVO vo);

	// ���� ��� ������Ʈ
	public abstract int stockorder(StockVO vos);

	// ���� �Ǹŵ� ����
	public abstract ArrayList<CoffeeVO> Getsellcount();

	// ��� ��ǰ ��ϵ��� ����
	public abstract ArrayList<CoffeeVO> GetAllSellList();
	
	// �������� ������� ��������
	public abstract StockVO getstock();
	
	//��� �޾Ƽ� ������Ʈ�� ������ش�
	public Object[][] makestocklistArr(StockVO lists);
	
	// �������� ������� ��������
//	public abstract ArrayList<StockVO> getstock();
	
	

	
	
	
	
	
	
//	// ArrayList�� �޾Ƽ� ��ü�� 2���� �迭�� ������ִ� �޼ҵ�
//	public abstract Object[][] makeArr(ArrayList<CoffeeVO> lists);
//
//	// ���͸� �޾Ƽ� �Ǵ뷮�� 2���� �迭�� ������ִ� �޼ҵ�
//	public abstract Object[][] makelistArr(ArrayList<CoffeeVO> lists);
//
//	// ��Ź�� �޾Ƽ� ������Ʈ�� �������
//	public abstract Object[][] makestocklistArr(StockVO lists);

}

