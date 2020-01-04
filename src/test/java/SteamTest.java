
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class SteamTest {

    /**
     * 阿里员工类
     */
    class AliEmp {
        private Long empId;
        private String name;
        private String department;
        private Integer workTime;

        public Long getEmpId() {
            return empId;
        }

        public void setEmpId(Long empId) {
            this.empId = empId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public Integer getWorkTime() {
            return workTime;
        }

        public void setWorkTime(Integer workTime) {
            this.workTime = workTime;
        }
    }


    /* 测试用例 */
    public void test() {
        List<AliEmp> empList = new ArrayList<>();


        /**
         * 获取菜鸟的员工
         * filter map collect
         */
        List<String> cainiaoEmpNameList = empList.stream()
                .filter(emp -> emp.getDepartment().equals("cainiao"))
                .map(AliEmp::getName)
                .collect(Collectors.toList());

        /**
         * 统计菜鸟员工的数量
         * filter count
         */
        long cainiaoEmpCount = empList.stream()
                .filter(emp -> emp.getDepartment().equals("cainiao"))
                .count();

        /**
         * 按照工号打印出所用员工的信息
         * sorted foreach
         */
        empList.stream().sorted(comparing(AliEmp::getEmpId)).forEach(System.out::println);

        /**
         * 统计员工花名的汉字
         * flatmap 汇总一个流 ***
         */
        Set<String> nameCharacter = empList.stream()
                .map(emp -> emp.getName().split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toSet());

        /**
         * 判断是否存在菜鸟员工
         * anyMatch 单一匹配
         * allMatch 全部匹配
         */
        boolean isCainiaoEmp = empList.stream().anyMatch(emp -> emp.getDepartment().equals("cainiao"));

        /**
         * 任意获取一个菜鸟员工
         * Optional类可以避免nullPointerException，表示一个值存在或者不存在
         * 常用方法有  isPresent(), get(), orElse()
         */
        Optional<AliEmp> oneCainiao = empList.stream()
                .filter(emp -> emp.getDepartment().equals("cainiao"))
                .findAny();

        /**
         * 获取第一个菜鸟员工
         */
        Optional<AliEmp> firstCainiao = empList.stream()
                .filter(emp -> emp.getDepartment().equals("cainiao"))
                .findFirst();

        /**
         * 累加所有员工个的工作时间
         * reduce 累加器
         */
        int totalWorktime = empList.stream().map(emp -> emp.getWorkTime())
                .reduce(0, Integer::sum);

        /**
         * 并行累加所有员工个的工作时间
         * mapToInt mapToDouble mapToLong 数值流IntStream, DoubleStream, LongStream
         * 数值流方法 sum() max() min() average() 等...
         */
        int worktimeSum = empList.stream().parallel()
                .mapToInt(AliEmp::getWorkTime)
                .sum();


        /**
         * 获取员工最小工号
         */
        OptionalLong minEmpId = empList.stream().mapToLong(AliEmp::getEmpId).min();


        /**
         * 根据部门对员工进行分组
         * groupingBy分组   返回map
         */
        Map<String, List<AliEmp>> group = empList.stream().collect(groupingBy(AliEmp::getDepartment));

        /**
         * 统计每个部门的人数
         */
        Map<String, Long> departmentEmpNum = empList.stream().collect(groupingBy(AliEmp::getDepartment, counting()));

        /**
         * 根据员工工号奇偶分区
         * partitionBy true or false
         */
        Map<Boolean, List<AliEmp>> partition = empList.stream()
                .collect(partitioningBy(emp -> emp.getEmpId() % 2 == 0));

    }


}
