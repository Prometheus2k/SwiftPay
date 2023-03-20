import * as React from 'react';
import { DataGrid, GridToolbar } from '@mui/x-data-grid';
// import transactionData from './generated.json';
import { Box } from '@mui/material';
import './transactionHistory.css';
import { GetTransactionHistory } from './HistoryService';



export default function TransactionHistory() {


    const columns = [
        {
            field: 'transactionId',
            headerName: 'Transaction Id',
            headerAlign: 'center',
            width: 250,
            flex: 1

        },
        {
            field: 'timeStamp',
            headerName: 'Time Stamp',
            headerAlign: 'center',
            width: 250,
            flex: 1
        },
        {
            field: 'description',
            headerName: ' Description',
            headerAlign: 'center',
            width: 250,
            flex: 1,

        },
        {
            field: 'toAccountNumber',
            headerName: 'To Account Number',
            width: 250,
            headerAlign: 'center',
            flex: 1
        },
        {
            field: 'fromAccountNumber',
            headerName: 'From Account Number',
            headerAlign: 'center',
            width: 250,
            flex: 1
        },
        {
            field: 'amount',
            headerName: 'Amount',
            headerAlign: 'center',
            width: 250,
            flex: 1
        },
        {
            field: 'status',
            headerName: 'Status',
            headerAlign: 'center',
            width: 250,
            flex: 1
        },
    ];

    const rows = GetTransactionHistory().then(
        (res) => {
            let rowdata = GetTransactionHistory;
        }
    )

    return (
        <>
            <div className='transactionDiv'>
                {console.log("row Data ----- " + rows + "-----" + rowdata)}
                <h1>Transaction History</h1>
                <Box sx={{ height: ' 100vh', width: '100%', alignItems: "center" }}>
                    <DataGrid sx={{ m: 2 }} autoHeight
                        rows={rows}
                        columns={columns}
                        initialState={{
                            pagination: {
                                paginationModel: {
                                    pageSize: 5,
                                },
                            },
                        }}
                        pageSizeOptions={[5, 10, 15, 25]}
                        slots={{
                            toolbar: GridToolbar,
                        }}

                    />
                </Box>
            </div>



        </>
    );
}
