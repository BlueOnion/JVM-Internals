javac GC_test.java

echo 128m, ParallelOld >> result.csv
java -Xms128m -Xmx128m -XX:+UseParallelOldGC GC_test 10  >> result.csv
echo 128m, CMS >> result.csv
java -Xms128m -Xmx128m -XX:+UseConcMarkSweepGC GC_test 10 >> result.csv
echo 128m, G1 >> result.csv
java -Xms128m -Xmx128m -XX:+UseG1GC GC_test 10 >> result.csv

echo 512m, ParallelOld >> result.csv
java -Xms512m -Xmx512m -XX:+UseParallelOldGC GC_test 10 >> result.csv
echo 512m, CMS >> result.csv
java -Xms512m -Xmx512m -XX:+UseConcMarkSweepGC GC_test 10 >> result.csv
echo 512m, G1 >> result.csv
java -Xms512m -Xmx512m -XX:+UseG1GC GC_test 10 >> result.csv

echo 1g, ParallelOld >> result.csv
java -Xms1g -Xmx1g -XX:+UseParallelOldGC GC_test 10 >> result.csv
echo 1g, CMS >> result.csv
java -Xms1g -Xmx1g -XX:+UseConcMarkSweepGC GC_test 10 >> result.csv
echo 1g, G1 >> result.csv
java -Xms1g -Xmx1g -XX:+UseG1GC GC_test 10 >> result.csv