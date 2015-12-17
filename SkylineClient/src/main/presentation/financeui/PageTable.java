package main.presentation.financeui;


import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class PageTable extends JTable{
			
			 //JTable���ҳ��Ϣ��ر���
		 public int currentPage=1;
		 public int pageCount=10;
		 public int totalPage=0;	
		 public int totalRowCount=0;
		 public int column=0;
		 public int restCount;
		 public String[][] resultData;
		 //JTable����Ϣ��ر���
		 private String[]	tableTitle ;
		 private String[][]	tableData ;
		
		 public DefaultTableModel model=null;
		 
		 
		 public void setTableTitle(String[] tableTitle) {
			this.tableTitle = tableTitle;
		}

		public void setTableData(String[][] tableData) {
			this.tableData = tableData;
		}
		 
		 public PageTable(String[] tableTitle,String[][] tableData){
			 this.tableTitle = tableTitle;
			 this.tableData = tableData;
			 initTable();
			 }
			 /**
			  * ��ȡ��һҳ
			  */
		 public int getNextPage(){
			 if(this.currentPage!=this.totalPage){
				 int a =++currentPage;
				 System.out.println("currentPage::::"+a);
				 return a;
			  }
			 System.out.println("totalPage::::"+this.totalPage);		
			  return -1;
		 }
			 /**
			  * ��ȡ��һҳ
			  */
		public int getPreviousPage(){
			 if(this.currentPage!=1&&this.currentPage>0){
				 int a =--currentPage;
				 System.out.println("currentPage::::"+a);
				 return a;
			
			 }
			 System.out.println("totalPage::::"+this.totalPage);		
			 	return -1;
		}
			 /**
			  * ��ȡ���һҳ
			  */
		public int getLastPage(){
			return this.totalPage;
		}
			 /**
			  * ��ȡ��һҳ
			  */
		public int getFirstPage(){
			return 1;
		}
			 /**
			  * ��ȡ��ҳ��
			  */
		public int getTotolPage(){
			return this.totalPage;
		}
			 /**
			  * ��ȡ��ǰҳ
			  */
		public int getCurrentPage(){
			return this.currentPage;
		}
			 /**
			  * ���ԭʼ���ݼ�
			  * @param students
			  * @return
			  */
/*		public String[][] getData(List<String> institutions){
			if( institutions.size()>0){
			   String[][] data=new String[ institutions.size()][4];
			   for(int i=0;i< institutions.size();i++){
			   String s= institutions.get(i);
			   String[] a={s.getId(),s.getName(),s.getSex(),s.getAge()};//��List���ϵ����ݸ���Object����
			   data[i]=a;//�������ֵ������ά�����һ��
			   }
			   return data;
			}
			   return null;
		}
	*/		 /**
			  * ��ʼ�������
			  * @param data
			  */
		public void initResultData(String[][] data){
			 if(data!=null){
			   resultData=data;//�ܵĽ����
			   column=data[0].length;//�������
			   totalRowCount=data.length;//��ĳ���
			   totalPage=totalRowCount%pageCount==0?totalRowCount/pageCount:totalRowCount/pageCount+1;//���������ҳ��
			   restCount=totalRowCount%pageCount==0?5:totalRowCount%pageCount;//���һҳ��������
			  }
		}
			 /**
			  * ��ȡ��ҳ����
			  * @return
			  */
		public String[][] getPageData(){
			 String[][] currentPageData=new String[pageCount][column];//����ÿҳ���ݼ�
			 if(this.getCurrentPage()<this.totalPage){//�����ǰҳ��С����ҳ������ôÿҳ��ĿӦ���ǹ涨����pageCount
			   for(int i=pageCount*(this.getCurrentPage()-1);i<pageCount*(this.getCurrentPage()-1)+pageCount;i++){
			    for(int j=0;j<column;j++){
			     //�ѽ�����ж�Ӧÿҳ��ÿһ������ȫ����ֵ����ǰҳ��ÿһ�е�ÿһ��
			     currentPageData[i%pageCount][j]=resultData[i][j];
			    }
			   }
			  }else{
			   //�ڶ�̬�ı����ݽ������ʱ�������ǰҳû�������ˣ���ص�ǰһҳ��һ��������һҳ���ԣ�
			   if(pageCount*(this.getCurrentPage()-1)>=totalRowCount)this.currentPage--;
			   for(int i=pageCount*(this.getCurrentPage()-1);i<pageCount*(this.getCurrentPage()-1)+restCount;i++){
			    for(int j=0;j<column;j++){
			     currentPageData[i%pageCount][j]=resultData[i][j];
			    }
			   }
			  } 
			  return currentPageData;
		}
			 /**
			  * ��ʼ���������
			  */
		public void initTable(){
			 if(tableData!=null){
			   initResultData(tableData);
			   model=new DefaultTableModel(getPageData(),tableTitle); 
			  }else{
			   //����������û�����ݣ���ô���ÿ����������ݼ��е�ÿһ��
			   String[][] nothing=null;
			   model=new DefaultTableModel(nothing , tableTitle);
			   totalRowCount=0;
			  }
			  this.setModel(model);
			  this.setRowHeight(20);
			  DefaultTableCellRenderer r=new DefaultTableCellRenderer();
			        r.setHorizontalAlignment(JLabel.CENTER);
			        setDefaultRenderer(Object.class, r);
			 }
}