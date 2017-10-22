/**
 * 
 */
package urssimulationmapinterface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import com.tutorial.protobuf.URS_WearableProto;
import com.tutorial.protobuf.URS_WearableProto.drone_id;
import com.tutorial.protobuf.URS_WearableProto.drone_id.Builder;
import com.tutorial.protobuf.URS_WearableProto.Goto;
import com.tutorial.protobuf.URS_WearableProto.At;
import com.tutorial.protobuf.URS_WearableProto.mission;


/**
 * @author Nasim
 *
 */
public class ProtocolBufferDemo {
	
	public void Demo()
	{
		System.out.println("........Protocol Buffer Starts......");
		
		//.....The Hand Coded Information in Below Should be Changed......//
		
		//....Message for Drone ID........//
		Builder droneidbuild = URS_WearableProto.drone_id.newBuilder();
		droneidbuild.setUavId(1);
		
		//....Message for Goto.....//
		Goto objgoto = URS_WearableProto.Goto.newBuilder().setUavId(1).setX(4.00).setY(5.00).setZ(6.00).setYaw(7.00).build(); 
		
		//....Message for At.....//
		At objat = URS_WearableProto.At.newBuilder().setUavId(1).setX(8.00).setY(9.00).setZ(10.00).setYaw(11.00).build(); 
		
		//....Message for mission.....//
		mission objmission = URS_WearableProto.mission.newBuilder().setStart("Start").setPause("Pause").setReset("Reset").build(); 
	
	   //.....Object Build for Drone ID...//	
	   drone_id objdroneid=droneidbuild.build();
	   
	   //......The File Path Should be Changed According to the Location of the File....// 
	   
	   try {
	        //.....Write into the File......//
	        FileOutputStream output = new FileOutputStream("H://MyProjects/URSSimulationMapInterface/URS_Wearable.txt");
	        objdroneid.writeTo(output);
	        objgoto.writeTo(output);
	        objat.writeTo(output);
	        objmission.writeTo(output);
	        output.close();
	 
	        //.....Read from the File.......//
	        drone_id showdroneid = drone_id.parseFrom(new FileInputStream("H://MyProjects/URSSimulationMapInterface/URS_Wearable.txt"));
	        System.out.println(showdroneid);
	        
	        Goto showgoto = Goto.parseFrom(new FileInputStream("H://MyProjects/URSSimulationMapInterface/URS_Wearable.txt"));
	        System.out.println(showgoto);
	        
	        At showat = At.parseFrom(new FileInputStream("H://MyProjects/URSSimulationMapInterface/URS_Wearable.txt"));
	        System.out.println(showat);
	        
	        mission showdmission = mission.parseFrom(new FileInputStream("H://MyProjects/URSSimulationMapInterface/URS_Wearable.txt"));
	        System.out.println(showdmission);
	     } catch (IOException e) {
	             e.printStackTrace();
	     }
		
	   System.out.println("........Protocol Buffer Ends......");
	}

}
