# JVM-Internals

Lab1. <br/>
Co powoduje przepełnienie pamięci?
Do działania programu potrzebne jest więcej pamięci, jeśli więc uruchomimy program wraz z parametrem -Xmx12m pojawi się błąd, ponieważ 12 MB to za mało miejsca 
do realizacji programu.

Lab3-4. <br/>
Aby uruchomić program należy w konsoli wywołać skrypt test.sh - w skrypcie występuje arybut 10, jest to n, czyli liczba wątków przeze mnie określona<br/>
Wyniki mojego testu dodałam do folderu w pliku result.csv. <br/>
W przypadku jednego wątku najgorsze wyniki otrzymał algorytm ParallelOld, a w przypadku n wątków algorytm G1. Wydaje mi się, że pozostałe algorytmy w każdym z przypadków działają porównywalnie.

Lab5. <br/>
SimpleDataFormat nie jest bezpieczny wątkowo, ponieważ przechowuje pośrednie wyniki w polu instancji. Generalnie, jeśli wszystkie wątki korzystają z tej jednej instancji to wyniki mogą się mieszać. Dlatego wykorzystałam ThreadLocal, w moim programie, każdy wątek ma swoją własną instancję SimpleDataFormat, dzięki czemu nie są one od siebie zależne i dają dobre wyniki. <br/>

Lab6. <br/>
mvn package<br/>
java -jar target\app.jar<br/>
jar cfm target\myagent.jar src\MyManifest.mf -C target\classes\ .<br/>
java -javaagent:target\myagent.jar -cp target\classes -jar target/app.jar >> plik.txt<br/>

Lab7. <br />
mvn install <br />
mvn assembly:assembly <br />
mvn exec:exec <br/>
http://localhost:4567/hello/10 - ostatni argument przekazuje liczbę milisekund, która ma być zmieniona w funkcji <br/>

Lab9. <br />
Uzupełniłam ze strumieni tyle funkcji ile umiałam. <br />
