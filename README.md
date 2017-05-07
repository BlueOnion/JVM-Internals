# JVM-Internals

Lab1. <br/>
Co powoduje przepełnienie pamięci?
Do działania programu potrzebne jest więcej pamięci, jeśli więc uruchomimy program wraz z parametrem -Xmx12m pojawi się błąd, ponieważ 12 MB to za mało miejsca 
do realizacji programu.

Lab5. <br/>
SimpleDataFormat nie bezpieczny wątkowo, ponieważ przechowuje pośrednie wyniki w polu instancji. Generalnie, jeśli wszystkie wątki korzystają z tej jednej instancji to wyniki mogą się mieszać. Dlatego wykorzystałam ThreadLocal, w moim programie, każdy wątek ma swoją własną instancję SimpleDataFormat, dzięki czemu nie są one od siebie zależne i dają dobre wyniki. <br/>

Lab6. <br />
mvn install <br />
mvn assembly:assembly <br />
mvn exec:exec
