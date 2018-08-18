import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.InflaterInputStream;

import com.google.gson.Gson;

public class BPCC {

	static Map<String, Integer> map = new HashMap<String, Integer>();
	
	static {
		map.put("inserter", 13);
		map.put("long-handed-inserter", 18);
		map.put("fast-inserter", 46);
		map.put("filter-inserter", 52);
		map.put("stack-inserter", 132);
		map.put("stack-filter-inserter", 132);
		
		map.put("electric-mining-drill", 90);
		map.put("electric-furnace", 180);
		map.put("pump", 30);
		map.put("small-lamp", 5);
		map.put("programmable-speaker", 2);
		map.put("pumpjack", 90);
		map.put("oil-refinery", 420);
		map.put("chemical-plant", 210);
		map.put("centrifuge", 350);
		map.put("lab", 60);
		map.put("beacon", 480);
		map.put("laser-turret", 2400);
		map.put("radar", 300);
		map.put("rocket-silo", 4000);
		
		map.put("arithmetic-combinator", 2);
		map.put("decider-combinator", 2);
		
		map.put("assembling-machine-1", 90);
		map.put("assembling-machine-2", 150);
		map.put("assembling-machine-3", 210);
	}
	
	public static void main(String[] args) throws IOException {

		if (args.length > 0) {

			String blueprintString = removeFirstByte(args[0]);

			byte[] decoded = decodeBase64String(blueprintString);

			String result = inflate(decoded);
			
			calculatePowerConsumption(result);

		}

	}

	public static void calculatePowerConsumption(String result) {
		Gson gson = new Gson();

		FactorioBlueprint factorioBlueprint = gson.fromJson(result, FactorioBlueprint.class);

		Entities[] entities = factorioBlueprint.getBlueprint().getEntities();

		int power = 0;

		System.out.print("Calculating\r");
		
		for (Entities entity: entities) {
			
			for (String key: map.keySet()) {
				
				if (entity.getName().equals(key)) {
					
					power += map.get(key);
					
				}
				
			}
			
		}

		if (power < 1000) {
			System.out.printf("Max. Power Consumption: %d kW", power);
		} else if (power > 1000) {
			System.out.printf("Max. Power Consumption: %.1f MW", power / 1000.0);
		} else if (power > 1000000) {
			System.out.printf("Max. Power Consumption: %.1f GW", power / 1000000.0);
		}
		
	}

	public static String inflate(byte[] decoded) throws IOException {
		System.out.print("Inflating\r");
		
		ByteArrayInputStream bais = new ByteArrayInputStream(decoded);
		InflaterInputStream iis = new InflaterInputStream(bais);

		String result = "";
		byte[] buf = new byte[5];
		int rlen = -1;
		while ((rlen = iis.read(buf)) != -1) {
			result += new String(Arrays.copyOf(buf, rlen));
		}
		return result;
	}

	public static String removeFirstByte(String string) {

		String noVersion = "";

		for (int i = 1; i < string.length(); i++) {
			noVersion += string.charAt(i);
		}

		return noVersion;

	}

	public static byte[] decodeBase64String(String string) {
		System.out.print("Decoding\r");
		
		byte[] decoded = Base64.getMimeDecoder().decode(string);

		return decoded;

	}

}
