import React, { useEffect } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import AddCustomer from "./components/AddCustomer";
import Customers from "./components/Customers";
import Navbar from "./components/Navbar";
import NotFound from "./components/NotFound";

function App() {
    useEffect(() => {
        console.log("hello");
    }, []);

    return (
        <BrowserRouter>
            <Navbar />
            <Routes>
                <Route path="/" element={<Customers />} />
                <Route path="/add" element={<AddCustomer />} />
                <Route path="*" element={<NotFound />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
