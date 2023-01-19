import { useEffect, useState } from "react";

import EmployeeCard from "./EmployeeCard";
import EmployeeImput from "./EmployeeImput";
import { temp } from "../interfaces/IEmployeeList";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import PageBar from "./PageBar";
import NewEmployeeCard from "./NewEmployeeCard";

const SERVER_URL = "http://server.test:30011/people/";
//for out of minikube testing const SERVER_URL = 'http://localhost:8080/people/'; 

const EmployeeList = () => {
    let [employeeArray, setEmployeeArray] = useState(temp)
    let [editIndex, setEditIndex] = useState(-1)
    let [pageNum, setPageNum] = useState(0)
    const pageLen = 15;

    const getEmplyees = () => {
        fetch(SERVER_URL)
            .then(response => response.json())
            .then(data => {
                setEmployeeArray(data);
            })
            .catch(error => { });
    }

    useEffect(() => {
        getEmplyees()
    }, [])

    const addEmployee = (name: string, email: string, age: number) => {
        console.log("called")
        console.log(name)
        console.log(email)
        console.log(age)
        fetch(SERVER_URL, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                {
                    "name": name,
                    "email": email,
                    "age": age
                }
            )
        }).then(() => { getEmplyees() })
    }

    let backPage = (pageNum: number) => {
        if (pageNum > 0) { setPageNum(pageNum - 1) }
    }

    let forwardPage = (pageNum: number) => {
        if ((pageNum + 1) * pageLen <= employeeArray.employees.length + 1) {
            setPageNum(pageNum + 1)
        }
    }

    // let css = {
    //     display: "grid",
    //     gridTemplateColumns: "repeat(auto-fill, 301px)", //the width of the card 
    //     justifyContent: "center",
    //     gridGap: "20px",
    // }

    return (
        <div>
            <p></p>
            <PageBar
                backPage={backPage}
                forwardPage={forwardPage}
                pageNum={pageNum}
            />
            <Grid container spacing={1}>
                {employeeArray.employees
                    .concat([{ name: "name", email: "email", age: 0 }])
                    .slice(pageNum * pageLen, pageNum * pageLen + pageLen)
                    .map((employee, index): any => {
                        return (
                            <Grid item xs={12} sm={6} md={4}>
                                {(pageNum * pageLen + index === employeeArray.employees.length) ?
                                    <NewEmployeeCard
                                        addEmployee={addEmployee}
                                        key={index}
                                    /> :
                                    <EmployeeCard
                                        key={index}
                                        employee={employee}
                                    />}
                            </Grid>
                        )
                    })
                }
            </Grid>
            <PageBar
                backPage={backPage}
                forwardPage={forwardPage}
                pageNum={pageNum}
            />
            <p></p>
        </div>
    )
}



export default EmployeeList