package DataService;

//�ֿ�
public interface WarehouseDataService {
	
	//��� storageOrder��ʾ���Ķ���������warehouseNumber��ʾ�ֿ���
	//���ʱ��ϵͳ��Ҫ�����Ķ����ű�������Ӧ�ֿ�����ݿ�
	public void storage(order storageOrder,String warehouseNumber);
	
	//���� storageOrder��ʾ���Ķ���������warehouseNumber��ʾ�ֿ���
	//�轫�ֿ�����ݿ��еĶ����Ŷ�ȡ������ɾ��
	public order outWarehouse(order storageOrder,String warehouseNumber);
	
	//����Ӧ�ֿ���Ķ�����ȫ����ȡ���� 
	//warehouseNumber��ʾ�ֿ���
	public order readWarehouse(String warehouseNumber);
}
