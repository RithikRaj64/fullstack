import PropTypes from "prop-types";
import { useNavigate } from "react-router-dom";

import { useDispatch } from "react-redux";
import { setCrsId } from "../../../redux/viewSlice";

function CourseCard({details}) {

    const nav = useNavigate();
    const dispatch = useDispatch();

    
    const handleClick = () => {
        dispatch(setCrsId(details.id));
        nav("/institute/course/view");
    }

    return (
        <div className="w-full flex flex-row bg-white border border-gray-200 rounded-xl shadow m-5">
            <div className="p-5 font-mono">
                <a href="#">
                    <h3 className="mb-2 text-md font-bold tracking-tighter hover:tracking-normal">{details.courseName}</h3>
                </a>
                <p className="mb-2 font-normal text-gray-700 tracking-tighter">{details.instituteName}</p>
                <p className="mb-5 font-normal text-gray-700 tracking-tighter">{details.noOfSemesters} Semesters / {details.duration} Years</p>
                <button onClick={handleClick} className="inline-flex text-white bg-blue-600 hover:bg-sky-800 hover:px-5 px-3 py-2 rounded-lg font-medium text-center focus:ring-4 focus:outline-none">
                    Explore Course
                    <svg className="rtl:rotate-180 w-3.5 h-3.5 ms-2 mt-1" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                        <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
                    </svg>
                </button>  
            </div>
        </div>
    )
}

CourseCard.propTypes = {
    details : PropTypes.shape({
        id: PropTypes.string.isRequired,
        instituteName: PropTypes.string.isRequired,
        courseName: PropTypes.string.isRequired,
        noOfSemesters: PropTypes.number.isRequired,
        duration: PropTypes.number.isRequired,
    }).isRequired
}

export default CourseCard;