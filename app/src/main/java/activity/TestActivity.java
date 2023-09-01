package activity;

import java.util.ArrayList;


import com.example.attandance.R;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import bean.AttendanceSessionBean;
import db.DBAdapter;

public class TestActivity extends Activity {

	Button submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_main);
		
		submit=(Button)findViewById(R.id.button1);
		
		
		
		
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				DBAdapter dbAdapter = new DBAdapter(TestActivity.this);
				AttendanceSessionBean attendanceSessionBean = new AttendanceSessionBean();
				
				
				attendanceSessionBean.setAttendance_session_faculty_id(1);
				attendanceSessionBean.setAttendance_session_department("CSE");
				attendanceSessionBean.setAttendance_session_class("BE");
				attendanceSessionBean.setAttendance_session_date("06/04/2016");
				attendanceSessionBean.setAttendance_session_subject("DataBase");
				
				dbAdapter.addAttendanceSession(attendanceSessionBean);
				Log.d("add", "inserted");
				

				
				
				ArrayList<AttendanceSessionBean> attendanceSessionBeanList = dbAdapter.getAllAttendanceSession();
				
				for(AttendanceSessionBean sessionBean : attendanceSessionBeanList)
				{
					Log.d("for", "in for loop");
					int aid = sessionBean.getAttendance_session_id();
					int fid = sessionBean.getAttendance_session_faculty_id();
					String sclass = sessionBean.getAttendance_session_class();
					String dept = sessionBean.getAttendance_session_department();
					String date=  sessionBean.getAttendance_session_date();
					String sub= sessionBean.getAttendance_session_subject();
					Log.d("id", aid+"");
					Log.d("fid", fid+"");
					Log.d("sclass", sclass);
					Log.d("dept",dept);
					Log.d("date", date);
					Log.d("sub", sub);
				}
			}
		});
		
		
		
		
		
		
		
		
		
	}

	

}
