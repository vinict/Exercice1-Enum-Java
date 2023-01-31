package Enums.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
   
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department; /* Somente um departamento será necessário, por isso uma variavel somente */
    private List<HourContract> contracts = new ArrayList(); /* Como um trabalhador pode ter varios contratos, utilizamos de uma lista para armazenar e efetuar os calculos necessarios */ 

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract){ /* Método para adicionar um contrato associado à um trabalhador */
        contracts.add(contract);
    }
    
    public void removeContract(HourContract contract){ /* Método para remover um contrato associado ao trabalhador */
        contracts.remove(contract);
    }
    
    public Double income(int year, int month){
        double soma = baseSalary;
        Calendar cal = Calendar.getInstance(); /* Declarar um calendário */
        for(HourContract c: contracts){
            cal.setTime(c.getDate());
            int contract_year = cal.get(Calendar.YEAR); /* a variavel ano de contrato e mês de contrato estão recebendo o ano do calendário que foi informado */
            int contract_month = 1 + cal.get(Calendar.MONTH); /* a variavel ano de contrato e mês de contrato estão recebendo o ano do calendário que foi informado */
            
            if(year == contract_year && month == contract_month){ /* Se ano for igual ao ano informado E mês for igual ao mês informado então */
               soma = soma + c.totalValue(); /* Soma recebe soma + valor total, afim de se descobrir o valor total que o funcionário recebeu no período de tempo informado */
            }
        }
        return soma; 
    }
    
    @Override
    public String toString() {
        return "Worker{" + "name=" + name + ", level=" + level + ", baseSalary=" + baseSalary + ", department=" + department + ", contracts=" + contracts + '}';
    }
}

