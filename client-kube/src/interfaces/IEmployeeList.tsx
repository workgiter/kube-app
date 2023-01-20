export interface IEmployee {
  id: string;
  name: string;
  email: string;
  age: number;
}

export interface IEmployeeList {
  employees: IEmployee[];
}

export var temp: IEmployeeList = {
  "employees": [
    {
      "id": "63caa150609a871dd0fea60c",
      "name": "hello this works now",
      "email": "danial.paucek@yahoo.com",
      "age": 37
    },
    { "id": "63caa150609a871dd0fea60d", "name": "Bertram", "email": "josef.marvin@gmail.com", "age": 35 }, { "id": "63caa150609a871dd0fea60e", "name": "Guy", "email": "horace.hermann@gmail.com", "age": 15 }, { "id": "63caa150609a871dd0fea60f", "name": "Dennis", "email": "tomasa.mayer@gmail.com", "age": 67 }, { "id": "63caa150609a871dd0fea610", "name": "Eugenio", "email": "alleen.quigley@yahoo.com", "age": 92 }, { "id": "63caa150609a871dd0fea611", "name": "Thad", "email": "slyvia.trantow@yahoo.com", "age": 16 }, { "id": "63caa16e609a871dd0fea612", "name": "hello this works now", "email": "danial.paucek@yahoo.com", "age": 37 }]
}