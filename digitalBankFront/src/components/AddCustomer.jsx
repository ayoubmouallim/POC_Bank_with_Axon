import axios from "axios";
import React, { useState } from "react";
import "../styles/customers.css";

function AddCustomer() {
    const [customer, setCustomer] = useState({
        name: "",
        email: "",
    });

    const saveCustomer = (e) => {
        e.preventDefault();
        console.log(customer);
        axios
            .post("http://localhost:8080/customers/commands/create", customer)
            .then((resp) => {
                console.log(resp);
            })
            .catch((err) => console.log(err));
        setCustomer({ name: "", email: "" });
    };

    return (
        <div className="  container mt-4  ">
            <div className="">
                <div className="modal-content">
                    <div className="modal-header">
                        <h4 className="modal-title">Add Customer</h4>
                    </div>
                    <div className="modal-body">
                        <div class="form-group">
                            <label>Name</label>
                            <input
                                type="text"
                                class="form-control"
                                value={customer.name}
                                onChange={(e) =>
                                    setCustomer({
                                        ...customer,
                                        name: e.target.value,
                                    })
                                }
                            />
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input
                                type="text"
                                class="form-control"
                                value={customer.email}
                                onChange={(e) =>
                                    setCustomer({
                                        ...customer,
                                        email: e.target.value,
                                    })
                                }
                            />
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-success" onClick={saveCustomer}>
                            Add
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default AddCustomer;
