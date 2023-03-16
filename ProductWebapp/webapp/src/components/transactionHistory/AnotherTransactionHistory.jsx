import * as React from 'react';
import PropTypes from 'prop-types';
import { useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableFooter from '@mui/material/TableFooter';
import TablePagination from '@mui/material/TablePagination';
import TableRow from '@mui/material/TableRow';
import IconButton from '@mui/material/IconButton';
import FirstPageIcon from '@mui/icons-material/FirstPage';
import KeyboardArrowLeft from '@mui/icons-material/KeyboardArrowLeft';
import KeyboardArrowRight from '@mui/icons-material/KeyboardArrowRight';
import LastPageIcon from '@mui/icons-material/LastPage';
import TableHead from '@mui/material/TableHead';
import 'bootstrap/dist/css/bootstrap.min.css';
import './TransactionHistory.css'
import { DataGrid } from '@mui/x-data-grid';


function TablePaginationActions(props) {
    const theme = useTheme();
    const { count, page, rowsPerPage, onPageChange } = props;

    const handleFirstPageButtonClick = (event) => {
        onPageChange(event, 0);
    };

    const handleBackButtonClick = (event) => {
        onPageChange(event, page - 1);
    };

    const handleNextButtonClick = (event) => {
        onPageChange(event, page + 1);
    };

    const handleLastPageButtonClick = (event) => {
        onPageChange(event, Math.max(0, Math.ceil(count / rowsPerPage) - 1));
    };

    return (
        <Box sx={{ flexShrink: 0, ml: 2.5 }}>
            <IconButton
                onClick={handleFirstPageButtonClick}
                disabled={page === 0}
                aria-label="first page"
            >
                {theme.direction === 'rtl' ? <LastPageIcon /> : <FirstPageIcon />}
            </IconButton>
            <IconButton
                onClick={handleBackButtonClick}
                disabled={page === 0}
                aria-label="previous page"
            >
                {theme.direction === 'rtl' ? <KeyboardArrowRight /> : <KeyboardArrowLeft />}
            </IconButton>
            <IconButton
                onClick={handleNextButtonClick}
                disabled={page >= Math.ceil(count / rowsPerPage) - 1}
                aria-label="next page"
            >
                {theme.direction === 'rtl' ? <KeyboardArrowLeft /> : <KeyboardArrowRight />}
            </IconButton>
            <IconButton
                onClick={handleLastPageButtonClick}
                disabled={page >= Math.ceil(count / rowsPerPage) - 1}
                aria-label="last page"
            >
                {theme.direction === 'rtl' ? <FirstPageIcon /> : <LastPageIcon />}
            </IconButton>
        </Box>
    );
}

TablePaginationActions.propTypes = {
    count: PropTypes.number.isRequired,
    onPageChange: PropTypes.func.isRequired,
    page: PropTypes.number.isRequired,
    rowsPerPage: PropTypes.number.isRequired,
};

function createData(transactionId, timeStamp, description, fromAccountNumber, toAccountNumber, amount, status) {
    return { transactionId, timeStamp, description, fromAccountNumber, toAccountNumber, amount, status };
}

const rows = [
    createData('23213434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 6000, 'fail'),
    createData('2321345341132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 104500, 'success'),
    createData('232134s2132132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 10040, 'success'),
    createData('23213434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 100230, 'success'),
    createData('2123434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 100330, 'success'),
    createData('23213434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 1000, 'success'),
    createData('34341434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 1000, 'success'),
    createData('23213434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 1000, 'success'),
    createData('123234132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 1000, 'success'),
    createData('23213434353134332', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 1000, 'success'),
    createData('23213434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 1000, 'success'),
    createData('23213434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 1000, 'success'),
    createData('23213434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 1000, 'success'),
    createData('23213434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 1000, 'success'),
    createData('23213434132132', '24/3/2001  2:15 am', 'Upi payment', '123456789', '987654321', 1000, 'success'),

];

export default function CustomPageTable() {
    const [page, setPage] = React.useState(0);
    const [rowsPerPage, setRowsPerPage] = React.useState(5);

    const columns = [
        { id: 'transactionId', label: 'Transaction ID', align: 'center' },
        { id: 'timeStamp', label: 'Date and Time', align: 'center' },
        {
            id: 'description',
            label: 'Description',
            align: 'center',

        },
        {
            id: 'fromAccountNumber',
            label: 'From Account Number',
            align: 'center',

        },
        {
            id: 'toAccountNumber',
            label: 'To Account Number',
            align: 'center',
        },
        {
            id: 'amount',
            label: 'Amount',
            align: 'center',
        },
        {
            id: 'status',
            label: 'Status',
            align: 'center',
        },
    ];
    const emptyRows =
        page > 0 ? Math.max(0, (1 + page) * rowsPerPage - rows.length) : 0;

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0);
    };

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


            <TableContainer  >
                <Table fixedHeader="false"
                    borderAxis="both" aria-label="custom pagination table">
                    <TableHead >
                        <TableRow >
                            {columns.map((column) => (
                                <TableCell
                                    key={column.id}
                                    align={column.align}
                                    padding="10px"

                                >
                                    {column.label}
                                </TableCell>

                            ))}
                        </TableRow>
                    </TableHead>
                    <TableBody >
                        {(rowsPerPage > 0
                            ? rows.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                            : rows
                        ).map((row) => (
                            <TableRow key={row.name}  >
                                <TableCell style={{ width: 10, border: '2px  solid black', padding: "", flex: "1" }} align="center" >
                                    {row.transactionId}
                                </TableCell>
                                <TableCell style={{ width: 10, border: '2px solid black', margin: "10px" }} align="center">
                                    {row.timeStamp}
                                </TableCell>
                                <TableCell style={{ width: 10, border: '2px solid black' }} align="center">
                                    {row.description}
                                </TableCell>
                                <TableCell style={{ width: 10, border: '2px solid black' }} align="center">
                                    {row.fromAccountNumber}
                                </TableCell>
                                <TableCell style={{ width: 10, border: '2px solid black', flex: "1" }} align="center">
                                    {row.toAccountNumber}
                                </TableCell>
                                <TableCell style={{ width: 10, border: '2px solid black' }} align="center">
                                    {row.amount}
                                </TableCell>
                                <TableCell style={{ width: 10, border: '2px solid black' }} align="center">
                                    {row.status}
                                </TableCell>
                            </TableRow>
                        ))}

                        {emptyRows > 0 && (
                            <TableRow style={{ height: 30 * emptyRows }}>
                                <TableCell colSpan={6} />
                            </TableRow>
                        )}
                    </TableBody>
                    <TableFooter>
                        <TableRow>
                            <TablePagination
                                rowsPerPageOptions={[5, 10, 15, 25, { label: 'All', value: -1 }]}
                                colSpan={6}
                                count={rows.length}
                                rowsPerPage={rowsPerPage}
                                page={page}
                                SelectProps={{
                                    inputProps: {
                                        'aria-label': 'rows per page',
                                    },
                                    native: true,
                                }}
                                onPageChange={handleChangePage}
                                onRowsPerPageChange={handleChangeRowsPerPage}
                                ActionsComponent={TablePaginationActions}
                            />
                        </TableRow>
                    </TableFooter>
                </Table>
            </TableContainer>
        </>


    );
}

// style = {{ display: "flex", justifyContent: 'space-evenly', flexDirection: 'column', margin: "10px" }}
