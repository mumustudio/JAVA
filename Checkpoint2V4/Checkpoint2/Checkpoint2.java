import java.io.IOException;
import java.io.Reader;
import javax.imageio.ImageIO;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
public class Checkpoint2 {
	static int playernum = 0;
	static Character[] Characters;
	static String path= Checkpoint2.class.getResource("").toString();
	

	public static void main(String[] args) {
		
		//// TODO: Announce the object of Character.////
		//// TODO: Call and execute the Random function.
		//// TODO: And Save it.
		//// TODO: Output a "output.txt" file
		
		path = path.replace("file:/", "");
		path = path.replace("/", "//");
		Load("1_Character.txt");
		
		//make all player money-100 location +1 and print
				for(int i=0;i<Characters.length;i++) {
					Characters[i].money -= 100;
					Characters[i].location +=1;
				}
				
				//print to console
				for(int i=0;i<Characters.length;i++) {
					System.out.println("Character_"+(i+1)+":");
					System.out.println("location:"+Characters[i].location);
					System.out.println("CHARACTER_NUMBER:"+Characters[i].CHARACTER_NUMBER);
					System.out.println("money:"+Characters[i].money);
					System.out.println("status:"+Characters[i].status);
					System.out.println("IMAGE_FILENAME:"+Characters[i].IMAGE_FILENAME);
					File picture = new File(path+Characters[i].IMAGE_FILENAME);
			        BufferedImage sourceImg =ImageIO.read(new FileInputStream(picture)); 
			        System.out.println("IMAGE_WIDTH:"+sourceImg.getWidth());
			        System.out.println("IMAGE_HEIGHT:"+sourceImg.getHeight());
				}
				
				//Save file and make output
				Save("1_Character.txt");
			

	}
	
	static void Load(String filename) throws IOException {
		//// TODO: You should load the variables from the file. ////
		FileReader fr = new FileReader(path+filename);
		BufferedReader br = new BufferedReader(fr);
		
		String[] character_info= new String[100]; //max for 100 player
		int info_index = 0;
		
		while( br.ready() ) {
			String line = br.readLine();
			if(line.startsWith("/")) {
				continue;
			}else {
				character_info[info_index] = line;
				playernum+=1;
				info_index += 1;
			}
		}
		br.close();
		
		Characters = new Character[playernum]; //Create player by txt file
		for (int i=0;i<playernum;i++)
			Characters[i] = new Character();
		
		for(int i=0;i<playernum;i++) {
			int location =Integer.parseInt(character_info[i].split(",")[0]);
			int characternumber = Integer.parseInt(character_info[i].split(",")[1]);
			int money = Integer.parseInt(character_info[i].split(",")[2]);
			int status = Integer.parseInt(character_info[i].split(",")[3]);
			String image_filename=character_info[i].split(",")[4];
			Characters[i].location = location;
			Characters[i].CHARACTER_NUMBER = characternumber;
			Characters[i].money = money;
			Characters[i].status = status;
			Characters[i].IMAGE_FILENAME = image_filename;
		}
		
		
	}

	static void Save(String filename) throws IOException {
		//// TODO: You should save the changed variables into original data (filename). ////
		FileWriter fw = new FileWriter(path+filename);
		BufferedWriter bw=new BufferedWriter(fw);	
		bw.write("//#變數名稱格式 (Character)location,CHARACTER_NUMBER,money,status,IMAGE_FILENAME//\r\n");
		for(int i=0;i<Characters.length;i++) {
			bw.write(Characters[i].location+","+Characters[i].CHARACTER_NUMBER+","+Characters[i].money+","+Characters[i].status+","+Characters[i].IMAGE_FILENAME+"\r\n");
		}
		bw.close();
		fw.close();
		
		//write to output.txt
		fw = new FileWriter(path+"output.txt");
		bw=new BufferedWriter(fw);
		for(int i=0;i<Characters.length;i++) {
			bw.write("Character_"+(i+1)+":"+"\r\n");
			bw.write("location:"+Characters[i].location+"\r\n");
			bw.write("CHARACTER_NUMBER:"+Characters[i].CHARACTER_NUMBER+"\r\n");
			bw.write("money:"+Characters[i].money+"\r\n");
			bw.write("status:"+Characters[i].status+"\r\n");
			bw.write("IMAGE_FILENAME:"+Characters[i].IMAGE_FILENAME+"\r\n");
			File picture = new File(path+Characters[i].IMAGE_FILENAME);
	        BufferedImage sourceImg =ImageIO.read(new FileInputStream(picture)); 
	        bw.write("IMAGE_WIDTH:"+sourceImg.getWidth()+"\r\n");
	        bw.write("IMAGE_HEIGHT:"+sourceImg.getHeight()+"\r\n");
		}
		bw.close();
		fw.close();
		
		
	}
	
	static void Random() {
		//// TODO: while calling the Random function, Character.location should plus the random value, and Character.status should minus one.
		//// TODO: Each Character object which you had loaded should be modified after calling the Random function.
		//// TODO: While Character.status more than zero(not include zero), Character can move(plus the random value).
		//// TODO: Before the next Character objects will be modified and after the previous Character has been modified, you should press ENTER to do next step(Let the next Character object be modified)
		//// TODO: In brief, before you modified the Character object, you should press ENTER, and then stop(wait) for another ENTER in order to modified next Character object
		//// TODO: While each of Character object has been modified or Character.status is zero, the Random function end.

	}

}
