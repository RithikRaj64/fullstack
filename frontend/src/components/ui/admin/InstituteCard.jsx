import college from "../../../assets/images/College.jpg";
import PropTypes from "prop-types";

import { useNavigate } from "react-router-dom";

import { useDispatch } from "react-redux";
import { setInsId } from "../../../redux/viewSlice";

function InstituteCard({data}) {

    const nav = useNavigate();
    const dispatch = useDispatch();

    const {id, instituteName, about} = data;

    const handleClick = () => {
        dispatch(setInsId(id));
        nav("/admin/institute/view");
    }

    return (
        <div className="max-w-sm bg-white border border-gray-200 rounded-xl shadow m-5">
            <a href="#">
                <img className="rounded-t-lg" src={college} alt="" />
            </a>
            <div className="p-5 font-mono">
                <a href="#">
                    <h3 className="mb-2 text-md font-bold tracking-tighter hover:tracking-normal">{instituteName}</h3>
                </a>
                <p className="mb-5 font-normal text-gray-700 tracking-tighter">{about}</p>
                <div className="grid grid-cols-2 justify-center space-x-2 text-sm">
                    <button onClick={handleClick} className="inline-flex justify-center text-white bg-blue-600 hover:bg-sky-800  px-3 py-2 rounded-lg font-medium text-center focus:ring-4 focus:outline-none">
                        View Details
                        <svg className="rtl:rotate-180 w-3.5 h-3.5 ms-2 mt-1" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                            <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
                        </svg>
                    </button> 
                </div>
            </div>
        </div>
    )
}


InstituteCard.propTypes = {
    data : PropTypes.shape({
        id: PropTypes.string.isRequired,
        instituteName: PropTypes.string.isRequired,
        about: PropTypes.string.isRequired,
    }).isRequired
}

export default InstituteCard;