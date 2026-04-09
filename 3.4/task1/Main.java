import java.io.*;
import java.net.URL;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Main {

	final static String file_url = "https://users.metropolia.fi/~jarkkov/temploki.csv";

	public static void main (String[] args) throws Exception {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

		double sum = 0;
		int    cnt = 0;
		URL url    = new URL(file_url);

		try(BufferedReader br = new BufferedReader(
					new InputStreamReader(url.openStream()))){
			
			String line;
			br.readLine();

			while((line = br.readLine()) != null){
				String[] sections = line.split(";");
				String timestamp  = sections[0];
				String temp 	  = sections[1];

				LocalDateTime dt = LocalDateTime.parse(timestamp, fmt);

				if(dt.toLocalDate().equals(LocalDate.of(2023, 1, 1))){
					double temperature = Double.parseDouble(temp.replace(",", "."));

					sum += temperature;
					cnt++;
				}
			}
		} catch(IOException e){
			System.out.println("Couldn't read file: " + e);
		}

		if(cnt > 0){	
			double avg = sum/cnt;
			System.out.printf("Average temp: %.2f%n", avg);
		}
	}
}
