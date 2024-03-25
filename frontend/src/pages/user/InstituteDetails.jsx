import college from "../../assets/images/College.jpg";

import { useEffect, useState } from "react";

import { useSelector } from "react-redux";
import { getId } from "../../redux/authSlice";
import { getInsId } from "../../redux/viewSlice";
import { getIns, getUser } from "../../services/user";

function InstituteDetails() {

    const id = useSelector(getInsId);
    const uid = useSelector(getId)

    const [details, setDetails] = useState({});
    const [user, setUser] = useState({});

    const getDetails = async () => {
        let res = await getIns(id);
        setDetails(res.data);
        let us = await getUser(uid);
        setUser(us.data);

        console.log(res.data);
        console.log(us.data);
        return;
    }

    useEffect(() => {
        getDetails();
    }, []);

    return (
        <div className="bg-sky-200 p-12 min-h-fit">
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

                                <div className="grid grid-cols-5">
                                    <p className="font-normal tracking-tighter">Website</p>
                                    <a href="//www.skcet.ac.in" target="blank" className="font-normal grid grid-cols-subgrid col-span-4 underline underline-offset-2 tracking-tighter">{details.website}</a>
                                </div>

                                <div className="grid grid-cols-5">
                                    <p className="font-normal tracking-tighter">Email address</p>
                                    <a href="mailto:principal.skcet.ac.in" className="font-normal grid grid-cols-subgrid col-span-4 underline underline-offset-2 tracking-tighter">info@skcet.ac.in</a>
                                </div>
                                
                                <div className="grid grid-cols-5">
                                    <p className="font-normal tracking-tighter">Contact Number</p>
                                    <a href="tel:9025760240" className="font-normal grid grid-cols-subgrid col-span-4 underline underline-offset-2 tracking-tighter">{user.mobile}</a>
                                </div>

                            </div>

                            {/* <a href="/user/courses/skcet" className="inline-flex text-white bg-blue-600 hover:bg-sky-800 hover:px-5 px-3 py-2 rounded-lg font-medium text-center focus:ring-4 focus:outline-none">
                                View Courses Offered
                                <svg className="rtl:rotate-180 w-3.5 h-3.5 ms-2 mt-1" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                                    <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
                                </svg>
                            </a>  */}
                        
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default InstituteDetails;