package dataservice;

import java.util.List;

import State.LoadType;

/**
 * װ����Ϣ�Ĳ����ӿ�
 * @author zengpan
 * order��ʾ��ݵ���
 */
public interface LoadDataService {
	
	//��дװ�˱����ݿ�
	//loadType��ö�����ͣ���װ�˵����� �𳵡��������ɻ�
	//centerNumber��ʾ��������ת����
	public void writeLoadBase(List<order> loadList,LoadType loadType,String centerNumber);
	
	//�����ݿ��ȡװ����Ϣ  LoadList��װ����Ϣ
	public List<order> readLoadBase();
	
	//ɾ�����ݿ����װ����Ϣ  loadListΪҪɾ����װ����Ϣ
	public void delLoadBase(List<order> loadList);
}
