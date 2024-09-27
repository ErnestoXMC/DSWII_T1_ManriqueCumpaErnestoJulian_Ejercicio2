package services;


import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class FormatFilesService {
	public String readAccountsAndGenerateFiles(String jsonFilePath, FileService fileService) {
	    try {
	        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
	        JSONArray jsonArray = new JSONArray(jsonContent);

	        for (int i = 0; i < jsonArray.length(); i++) {
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	            boolean estado = jsonObject.getBoolean("estado");
	            long nroCuenta = jsonObject.getLong("nro_cuenta");
	            double saldo = jsonObject.getDouble("saldo");
	            String banco = jsonObject.getString("banco");

	            if (estado) {
	                String content;
	                if (saldo > 5000.00) {
	                    content = "Banco de origen: " + banco +
	                              "\nLa cuenta con el nro de cuenta: " + nroCuenta + " tiene un saldo de " + saldo +
	                              "\nUsted es apto a participar en el concurso de la SBS por 10000.00 soles." +
	                              "\nSuerte!";
	                } else {
	                    content = "Banco de origen: " + banco +
	                              "\nLa cuenta con el nro de cuenta: " + nroCuenta + " no tiene un saldo superior a 5000.00." +
	                              "\nLamentablemente no podrá acceder al concurso de la SBS por 10000.00 soles." +
	                              "\nGracias";
	                }

	                // Crear archivo con el nombre de la cuenta
	                fileService.createAccountFile("cuenta_" + nroCuenta + ".txt", content);
	            }
	        }
	        return jsonContent;
	    } catch (Exception e) {
	        System.out.println("Ocurrió un error al procesar el archivo JSON: " + e.getMessage());
	        return null;
	    }
	}

}
