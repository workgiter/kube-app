import { useEffect, useState } from "react";

import EmployeeCard from "./EmployeeCard";
import { temp } from "../interfaces/IEmployeeList";
import Grid from "@mui/material/Grid";
import PageBar from "./PageBar";
import NewEmployeeCard from "./NewEmployeeCard";

const SERVER_URL = "http://server.test:30011/people/";
//for out of minikube testing 
//const SERVER_URL = 'http://localhost:8080/people/';

interface IUserDetails {
    username: string,
    password: string
}

interface IProps {
    userDetails: IUserDetails
}

const EmployeeList = (props: IProps) => {
    let [employeeArray, setEmployeeArray] = useState(temp)
    let [editIndex, setEditIndex] = useState("")
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

    const addEmployee = (id: string, name: string, email: string, age: number) => {
        let useServerURL;
        let empData;
        if (id === "asdf") {
            useServerURL = SERVER_URL
            empData = {
                "name": name,
                "email": email,
                "age": age
            }
        } else {
            useServerURL = SERVER_URL + "edit"
            empData = {
                "id": id,
                "name": name,
                "email": email,
                "age": age
            }
            setEditIndex("")
        }
        fetch(useServerURL, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(empData)
        }).then(() => { getEmplyees() })
    }

    const deleteEmployee = (id: string) => {
        let useServerURL = SERVER_URL + id;
        fetch(useServerURL, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                "Authorization": 'Basic ' + window.btoa(
                    props.userDetails.username
                    + ":"
                    + props.userDetails.password
                )
            }
        }).then(() => { getEmplyees() })
    }

    const backPage = (pageNum: number) => {
        if (pageNum > 0) { setPageNum(pageNum - 1) }
    }

    const forwardPage = (pageNum: number) => {
        if ((pageNum + 1) * pageLen <= employeeArray.employees.length + 1) {
            setPageNum(pageNum + 1)
        }
    }

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
                    .concat([{ id: "asdf", name: "", email: "", age: 0 }])
                    .slice(pageNum * pageLen, pageNum * pageLen + pageLen)
                    .map((employee, index): any => {
                        return (
                            <Grid item xs={12} sm={6} md={4}>
                                {(("asdf" === employee.id) || (employee.id === editIndex)) ?
                                    <NewEmployeeCard
                                        addEmployee={addEmployee}
                                        employee={employee}
                                        key={pageNum * pageLen + index}
                                        setEditIndex={(x: string) => setEditIndex(x)}
                                    /> :
                                    <EmployeeCard
                                        key={pageNum * pageLen + index}
                                        index={pageNum * pageLen + index}
                                        setEditIndex={(x: string) => setEditIndex(x)}
                                        employee={employee}
                                        deleteEmployee={deleteEmployee}
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