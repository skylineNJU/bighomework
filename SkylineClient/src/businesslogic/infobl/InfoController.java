package businesslogic.infobl;

import businesslogicservice.InfoBLService;
import vo.DriverVO;
import vo.InstitutionVO;
import vo.StaffVO;
import vo.VehicleVO;

public class InfoController implements InfoBLService {

	@Override
	public InstitutionVO createNewInstitution(String Category, String name, String position, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteInstitution() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InstitutionVO inquireInstitution(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InstitutionVO modifyInstitution(String Category, String name, String position, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffVO createNewStaff(String name, String job, String unit, String workage, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStaff() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StaffVO inquireStaff(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffVO modifyStaff(String name, String job, String unit, String workage, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleVO createNewVehicle(String name, String code, String age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteVehicle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VehicleVO inquireVehicle(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleVO modifyVehicle(String name, String code, String age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverVO createNewDriver(String name, String code, String age, String IDcode, String phoneNumber, String sex,
			String limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteDriver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DriverVO inquireDriver(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverVO modifyDriver(String name, String code, String age, String IDcode, String phoneNumber, String sex,
			String limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
