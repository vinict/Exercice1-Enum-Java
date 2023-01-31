package Enums.application;
import Enums.entities.Department;
import Enums.entities.HourContract;
import Enums.entities.Worker;
import Enums.entities.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.Locale;

/* Ler os dados de um trabalhador com N contratos (N fornecido pelo usuário). Depois, solicitar
do usuário um mês e mostrar qual foi o salário do funcionário nesse mês */

public class exercicio1 {
    public static void main(String[] args) throws ParseException{
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        
        /* Instanciamos um novo objeto do tipo worker, passando o nome, um instanciamento de workerlevel e valor de salario base, todos informados pelo usuário */ 
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
        
        
        System.out.print("How many contracts to this worker? ");
        int num = sc.nextInt();
        
        for(int i=0; i<num; i++){ /* For para leitura de todos os contratos do funcionário */ 
            System.out.printf("Enter contract #%d data:\n", i+1);
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next()); /* Ler a data informada do contrato no formato definido pelo exercício, onde definimos no sdf */
            
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            
            HourContract contract = new HourContract(contractDate, valuePerHour, hours); /*Associando a data, valor por hora e horas trabalhadas do funcionário, e todos esses 
                                                                                                contratos são associados à lista do trabalhador */
            worker.addContract(contract); /* Associa os contratos ao trabalhador */ 
        }
        
        System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        
        int month = Integer.parseInt(monthAndYear.substring(0,2)); /* Após lido a STRING de mês e ano, o mês irá receber os primeiros dois digitos da string,
                                                                                          onde serão transformados em INTEIROS pelo Integer.parseInt*/
        
        int year = Integer.parseInt(monthAndYear.substring(3)); /* Mesma coisa do mês, porém será pego a partir do 3 índice, que irá representar o ano, convertendo assim,
                                                                              a string para INTEIRO, também pelo Integer.parseInt */      
        
        System.out.printf("Name: %s", worker.getName());
        System.out.printf("\nDepartment: %s", worker.getDepartment().getName());
        System.out.printf("\nIncome for %d/%d: %.2f", month, year, worker.income(year, month));
        
        sc.close();
    }
}
