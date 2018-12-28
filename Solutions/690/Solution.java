/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> mapping = new HashMap<>();
        for(Employee employee : employees) {
            mapping.put(employee.id, employee);
        }
        
        return helper(mapping , id);
     }
    
    private int helper(Map<Integer, Employee> employees, int id) {
        Employee leader = employees.get(id);
        int result = leader.importance;
        
        if(leader.subordinates.size() == 0) {
            return result;
        }
        
        for(Integer sub : leader.subordinates) {
            result += helper(employees, sub);
        }
        
        return result;
    }
}