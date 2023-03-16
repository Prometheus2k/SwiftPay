
import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './TransactionHistory.css'
import Dropdown from 'react-bootstrap/Dropdown';


export default function TransactionHistory() {



    return (
        <>
            <h1>Transaction History</h1>
            <div className='filterDiv'>
                <form action="/from_date_selected">
                    <label for="fromDate">From Date : </label>
                    <input type="date" id="fromDate" name="formDate" />

                    <label for="Endate">End Date : </label>
                    <input type="date" id="endDate" name="endDate" />
                </form>
            </div>

            <div className='tableDiv'>
                <table >
                    <thead >
                        <tr className='hrow'>
                            <th>Transaction ID</th>
                            <th>Date and Time</th>
                            <th>Description</th>
                            <th>From Account Number</th>
                            <th>To Account Number</th>
                            <th>Amount</th>
                            <th>
                                <Dropdown >
                                    <Dropdown.Toggle variant="success" id="dropdown-basic">
                                        Status
                                    </Dropdown.Toggle>

                                    <Dropdown.Menu id="dropdown-men">
                                        <Dropdown.Item href="#/action-1">Success</Dropdown.Item>
                                        <Dropdown.Item href="#/action-2">Fail</Dropdown.Item>
                                    </Dropdown.Menu>
                                </Dropdown>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr className='brow'>
                            <td>635645823gdyhxh</td>
                            <td>10/10/2023</td>
                            <td>UPI Transaction</td>
                            <td>10002012073647</td>
                            <td>10002313239233</td>
                            <td>+1000</td>
                            <td>Success</td>
                        </tr>
                        <tr className='brow'>
                            <td>635645823gdyhxh</td>
                            <td>10/10/2023</td>
                            <td>UPI Transaction</td>
                            <td>10002012073647</td>
                            <td>10002313239233</td>
                            <td>+1000</td>
                            <td>Success</td>
                        </tr>
                        <tr className='brow'>
                            <td>635645823gdyhxh</td>
                            <td>10/10/2023</td>
                            <td>UPI Transaction</td>
                            <td>10002012073647</td>
                            <td>10002313239233</td>
                            <td>+1000</td>
                            <td>Success</td>
                        </tr>
                        <tr className='brow'>
                            <td>635645823gdyhxh</td>
                            <td>10/10/2023</td>
                            <td>UPI Transaction</td>
                            <td>10002012073647</td>
                            <td>10002313239233</td>
                            <td>+1000</td>
                            <td>Success</td>
                        </tr>

                    </tbody>
                </table>
            </div>
        </>
    )
}