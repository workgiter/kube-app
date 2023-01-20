import React from 'react';
import ReactDOM from 'react-dom/client';
import { render, screen } from '@testing-library/react';
import { act } from 'react-dom/test-utils';
import App from './App';
import EmployeeCard from './components/EmployeeCard';

let container: HTMLDivElement;

beforeEach(() => {
  container = document.createElement('div');
  document.body.appendChild(container);
});

afterEach(() => {
  document.body.removeChild(container);
});


test('renders Kubernetes App Java header', () => {
  render(<App />);
  const linkElement = screen.getByText(/Kubernetes App Java/i);
  expect(linkElement).toBeInTheDocument();
});

import { IEmployee } from './interfaces/IEmployeeList';
test('MUI card renders employee data in ', () => {
  const employee: IEmployee = {
    id: "adssdfgdsfg",
    name: "David",
    email: "David@gmail.com",
    age: 30
  }
  render(<EmployeeCard index={33} setEditIndex={(x: number): void => { }} key={1} employee={employee} />);

  const cardElement = screen.getByText("David");
  expect(cardElement).toBeInTheDocument();
  const cardElement2 = screen.getByText("David@gmail.com");
  expect(cardElement2).toBeInTheDocument();
  const cardElement3 = screen.getByText("30");
  expect(cardElement3).toBeInTheDocument();
});

import { temp } from "./interfaces/IEmployeeList";
import EmployeeList from './components/EmployeeList';
test('create list of cards once given empoyee data', () => {

  global.fetch = jest.fn(() => Promise.resolve({
    json: () => Promise.resolve(temp)
  })) as jest.Mock;

  act(() => {
    ReactDOM.createRoot(container).render(<EmployeeList />);
  });

  const cardList = container.getElementsByClassName("MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-o71an5-MuiPaper-root-MuiCard-root");
  expect(cardList.length).toEqual(40);
})

test('makes API call after page load', async () => {
  const temp2 = {
    employees: [
      { name: "This is a succesful called load", email: "danial.paucek@yahoo.com", age: 37 }
    ]
  }
  global.fetch = jest.fn(() => Promise.resolve({
    json: () => Promise.resolve(temp2)
  })) as jest.Mock;

  await act(async () => {
    ReactDOM.createRoot(container).render(<EmployeeList />);
    await new Promise((r) => setTimeout(r, 2000));
  });


  const cardElement = screen.getByText("This is a succesful called load");
  expect(cardElement).toBeInTheDocument();
})