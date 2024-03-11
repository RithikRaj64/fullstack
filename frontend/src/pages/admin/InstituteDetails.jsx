import college from "../../assets/images/College.jpg";

import { useEffect, useState } from "react";

import { useSelector } from "react-redux";
import { getInsId } from "../../redux/viewSlice";
import { getIns } from "../../services/user";

function InstituteDetails() {

    const id = useSelector(getInsId);

    const [details, setDetails] = useState({});

    const getDetails = async () => {
        let res = await getIns(id);
        setDetails(res.data);
        console.log(res.data);
        return;
    }

    useEffect(() => {
        getDetails();
    }, []);

    return (
        <div className="bg-sky-200 p-12 min-h-screen flex items-center">
            <div className="bg-white rounded-xl border border-gray-200 min-w-screen min-h-fit p-16 font-mono">
                <div className="grid grid-cols-3 space-x-20">
                    <div className="col-span-1 p-5 flex justify-center items-center">
                        <img src={college} className="rounded-xl" alt="Institute" />
                    </div>
                    <div className="col-span-2 flex justify-center items-center">
                        <div>

                            <div>
                                <h1 className="text-3xl font-bold tracking-tighter mb-1">{details.instituteName}</h1>
                                <p className="font-normal tracking-tighter mb-10">{details.location}</p>
                            </div>

                            <div>
                                <p className="font-normal tracking-tighter mb-10">{details.about}</p>
                            </div>
                            
                            <div className="leading-7 mb-10">

                                <div className="grid grid-cols-4">
                                    <p className="font-normal tracking-tighter">Website</p>
                                    <a href="//www.skcet.ac.in" target="blank" className="font-normal grid grid-cols-subgrid col-span-3 underline underline-offset-2 tracking-tighter">{details.website}</a>
                                </div>  

                                <div className="grid grid-cols-4">
                                    <p className="font-normal tracking-tighter">Email address</p>
                                    <a href="mailto:principal.skcet.ac.in" className="font-normal grid grid-cols-subgrid col-span-3 underline underline-offset-2 tracking-tighter">{details.email}</a>
                                </div>
                                
                                <div className="grid grid-cols-4">
                                    <p className="font-normal tracking-tighter">Contact Number</p>
                                    <a href="tel:9025760240" className="font-normal grid grid-cols-subgrid col-span-3 underline underline-offset-2 tracking-tighter">{details.mobile}</a>
                                </div>

                            </div>

                            <div className="grid grid-cols-2 justify-center space-x-2 text-sm">
                                <a href="/admin/courses/skcet" className="inline-flex text-white bg-blue-600 hover:bg-sky-800 hover:px-5 px-3 py-2 rounded-lg font-medium text-center focus:ring-4 focus:outline-none">
                                    View Courses Offered
                                    <svg className="rtl:rotate-180 w-3.5 h-3.5 ms-2 mt-1" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                                        <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
                                    </svg>
                                </a> 
                                <a href="#" className="inline-flex justify-center text-white bg-red-600 hover:bg-red-800 px-3 py-2 rounded-lg font-medium text-center focus:ring-4 focus:ring-red-300 focus:outline-none">
                                    Delete
                                    {/* <svg width="16" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" stroke="#ffffff"><g id="SVGRepo_bgCarrier" strokeWidth="0"></g><g id="SVGRepo_tracerCarrier" strokeLinecap="round" strokeLinejoin="round"></g><g id="SVGRepo_iconCarrier"> <path d="M10 11V17" stroke="#000000" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"></path> <path d="M14 11V17" stroke="#000000" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"></path> <path d="M4 7H20" stroke="#000000" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"></path> <path d="M6 7H12H18V18C18 19.6569 16.6569 21 15 21H9C7.34315 21 6 19.6569 6 18V7Z" stroke="#000000" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"></path> <path d="M9 5C9 3.89543 9.89543 3 11 3H13C14.1046 3 15 3.89543 15 5V7H9V5Z" stroke="#000000" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"></path> </g></svg> */}
                                    <svg className="rtl:rotate-180 w-4 h-4 ms-2 mt-0.5" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" stroke="#000000">
                                        <g id="SVGRepo_bgCarrier" strokeWidth="0"/>
                                        <g id="SVGRepo_tracerCarrier" strokeLinecap="round" strokeLinejoin="round"/>
                                        <g id="SVGRepo_iconCarrier"> <path d="M10 11V17" stroke="#ffffff" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/> <path d="M14 11V17" stroke="#ffffff" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/> <path d="M4 7H20" stroke="#ffffff" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/> <path d="M6 7H12H18V18C18 19.6569 16.6569 21 15 21H9C7.34315 21 6 19.6569 6 18V7Z" stroke="#ffffff" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/> <path d="M9 5C9 3.89543 9.89543 3 11 3H13C14.1046 3 15 3.89543 15 5V7H9V5Z" stroke="#ffffff" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/> </g>
                                    </svg>
                                </a> 
                            </div>

                            
                        
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default InstituteDetails;