    Для первого запуска ничего менять не надо, для второго и последующего необходимо в application.yml вместо always поставить значение never
    Используемая БД постгресс. Для контекста данной задачи, было правильней использовать NoSQL бд, но у меня нет опыта
в подключении NoSql баз к проекту, поэтому, что б не тратить много времени сделал на реляционной БД. В реальном проекте использовал бы NoSQL
    Хранение в hashMap сопровождается возникновением коллизии, в результате чего время основных операций с коллекцией будет O(logN)
    Т.к. дефолтное количество дней в методе init не указано, задал его 7, что б вызывать в @PostConstruct.
    Для других случаев, можно вызывать этот метод из контроллера и передать ему нужное кол-во дней.
