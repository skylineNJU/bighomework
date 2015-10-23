package DataService;

	//��������
	//��Ա����
	//������Ϣ����
	//��ʻԱ��Ϣ����
public interface InfoDataService {

	//--------------��������--------------------
	
	//�����ݿ������ȡĳ���Ļ�����Ϣ
	//category Ϊ���������
	public String readInstitution(String category);
	
	//����ĳ���Ļ���
	//�½�һ���������������������ƣ�����λ�ã����
	//���ݿ�洢�û�����Ϣ
	public void addInstitution(String category,String name,String position,String code);
	
	//ɾ��ĳ����
	//������������֣����ݿ⽫ɾ���û���
	public void delInstitution(String name);
	
	//�޸�ĳ��������Ϣ����������Ϊ�����޸Ļ����ĵȼ��������ܽ�Ӫҵ����Ϊ��ת���ģ�������Ϣ���޸ģ�
	//String name,String position,String code��ʾҪ�޸ĵĲ��֣�������޸ģ����֮ǰ����Ϣһ��
	public void modifyInstitution(String category,String modifyName,String modifyPosition,String modifyCode);
	
	//�½�ְ������������ְ�����ƣ�ְλ�����ڵ�λ��ְ�������Լ����
	//���ݿ⽫�����Ա����Ϣ
	public void createNewStaff(String name,String job,String unit,String workage,String code);
		
	//���ݿ�ɾ����Ա����Ϣ
	//accountΪԱ�����˻�
	public void deleteStaff(String account);
		
	//���ݿⷵ�ظ��˻�����Ϣ
	//accountΪ��Ա�����˻�
	public String inquireStaff(String account);
		
	//�޸�ְ����Ϣ
	//accountΪ��Ա�����˻���account�����Ա��޸�
	//String modifyName,String modifyJob,String modifyUnit,String modifyWorkage��ʾҪ�޸ĵ�����
	public void modifyStaff(String modifyName,String modifyJob,String modifyUnit,String modifyWorkage,String account);
		
	//������ĳ�����Ϣ���������ݿ⣬���복�ƺţ�name�����������ţ�code�����Լ�����ʱ��
	public void createNewVehicle(String name,String code,String age);
		
	//ɾ��������Ϣ
	//code��ʾ��������
	public void deleteVehicle(String code);
		
	//��ѯ������Ϣ�����복������ ���ݿ��в�ѯ�ô��ŵĳ�����Ϣ
	public String readVehicle(String code);
	
	//�޸ĳ�����Ϣ
	public void modifyVehicle(String name,String code,String age);
		
	//�½�һ��˾����Ϣ������˾����š��������������ڡ����֤�š��ֻ� ���Ա���ʻ֤����
	public String createNewDriver(String name,String code,String age,String IDcode
				,String phoneNumber,String sex,String limit);
		
	//ɾ��˾����Ϣ
	public void deleteDriver();
		
	//��ѯ˾����Ϣ������˾�����
	public String inquireDriver(String code);
		
	//�޸�˾����Ϣ
	public String modifyDriver(String name,String code,String age,String IDcode
				,String phoneNumber,String sex,String limit);
}
