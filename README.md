# mortgage (ипотека)
REST сервис - оформление заявки на ипотеку.
В проекте использован Spring Boot, bd - H2, JUnit4, REST-assured.
Сделаны основные методы контролера.<br>
Отдельный клас для  проверки ИНН как юр.лица, так и физ. лица- там можно вообще весь объект проверять.<br>
При проверке обрабатываются исключения (не правильного ИНН и отсутствия заявки) и в соответствующем реквест отправляется объект (сущность описания ошибки)
для информирования о проблеме на фронтэнде.

Отдельно тест метода проверки ИНН и тест методов контролера (пока без теста PUT и DELETE)<br>
Обрабатываются следующие URI:<br>
GET:  /mortgage/  - получение всего списка заявок<br>
GET:  /mortgage/{id}  - получение заявки по номеру (id)<br>
POST: /mortgage/ с объектом в формате JSON<br>
PUT:  /mortgage/{id}  изменение заявки с номером (id)<br>
DELETE: /mortgage/{id} -удаление заявки по номеру (id)<br>
формат JSON для POST запроса:<br>
{<br>
    "customer":"",      //имя покупателя<br>
    "passport":"",      //паспорт покупателя<br>
    "address":"",       //адрес покупателя<br>
    "phon":"",          //номер телефона покупателя<br>
    "summa": ,          //сумма ипотеки<br>
    "duration": ,       //длительность (в годах)<br>
    "subject":"",       //объект (квартира, дом) с описанием и адресом<br>
    "supplier":"",      //продавец<br> 
    "supAddress":"",    //адрес продавца<br>
    "inn":""            //инн продавца<br>
}<br>
После записи в БД - возвращается ответ с полем "id" - номер в БД.<br>
Все проверено в POSTMAN