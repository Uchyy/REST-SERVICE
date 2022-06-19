# REST-SERVICE
REST microservice with api call from firebase database

Shangri-La Open Data REST API Specification
HTTP request:
GET ./GetAllQuestions
JSON Response:
{
 "consultations":{
 "Questions":[
 {
 "id":"1",
 "Text":"Do you have a petrol/diesel car?"
 },
 {
1 Once the question has been answered by at least one user, the Council Office will not be able to edit its question text
or options. 2 This might not follow the best REST API URL mapping practice, but we deliberately design the REST API in such a
way that no built-in REST libraries can be able to auto-generate the RESTful backend
 "id":"2",
 "Text":"Shall SLEZ apply to PHEVs (Plug-in hybrid electric vehicles)?"
 },
 {
 "id":"3",
 "Text":"What should be the proposed boundaries of SLEZ?"
 }
 ]
 }
}
HTTP request:
GET ./GetQuestionOptions/3/
JSON Response:
{
 "Question":"3",
 "Options":[
 {
 "id":"1",
 "Text":"Inside the inner ring road."
 },
 {
 "id":"2",
 "Text":"Outskrit of the town inside outer ring road."
 },
 {
 "id":"3",
 "Text":"Town centre postcodes starting with SL only."
 }
 ]
}
HTTP request:
GET ./GetQuestionResponse/3/
JSON Response:
{
 "Question":"3",
 "Answers":[
 {
 "id":"1",
 "count":"X"
 },
 {
 "id":"2",
 "count":"X"
 },
 {
 "id":"3",
 "count":"X"
 }
 ]
}
