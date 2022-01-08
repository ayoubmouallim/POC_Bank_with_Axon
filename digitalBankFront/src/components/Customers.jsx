import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import customersService from "../services/customersService";
import "../styles/customers.css";

function Customers() {
    const [customers, setCustomers] = useState([]);
    useEffect(() => {
        customersService
            .getCustomers()
            .then((response) => {
                console.log(response.data);
                setCustomers(response.data);
            })
            .catch((err) => console.log(err));
    }, []);

    return (
        <div class="container">
            <div>
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>
                                    Manage <b>Customers</b>
                                </h2>
                            </div>
                            <div class="col-sm-6">
                                <Link
                                    to="/add"
                                    class="btn btn-success"
                                    data-toggle="modal"
                                >
                                    <i class="material-icons">&#xE147;</i>{" "}
                                    <span>Add New Customer</span>
                                </Link>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Index</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Address</th>
                                <th>Phone</th>
                            </tr>
                        </thead>
                        <tbody>
                            {customers &&
                                customers.map((customer, key) => {
                                    return (
                                        <tr key={key}>
                                            <td>{key + 1}</td>
                                            <td>{customer.name}</td>
                                            <td>{customer.email}</td>
                                            <td>--</td>
                                            <td>(0) 0-0</td>
                                        </tr>
                                    );
                                })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default Customers;
