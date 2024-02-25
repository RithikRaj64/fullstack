import College from "../../assets/images/College.jpg"
import Course from "../../assets/images/Course.jpg"

function Home() {
    return (
        <div className="bg-sky-200 min-h-screen p-16">
            <div className="bg-white p-14 rounded-lg min-h-fit font-mono space-y-32">
                <div className="grid grid-cols-2 space-x-20">
                    <img src={Course} className="rounded-xl"/>
                    <div className="flex flex-col justify-center">
                        <h3 className="mb-2 text-md font-bold tracking-tighter hover:tracking-normal">Browse Courses: Explore Your Educational Journey</h3>
                        <p className="mb-2 font-normal text-gray-700 tracking-tighter">Discover a world of knowledge with our diverse range of courses designed to fuel your passion and shape your future. Our "Browse Courses" page offers a gateway to a multitude of academic opportunities. Explore undergraduate, postgraduate, and diploma programs across various disciplines. From computer science to arts, engineering to business, find the perfect course to elevate your skills and aspirations. Unleash your potential and embark on a transformative learning experience. Your educational journey starts here.</p>
                        <a href="/user/courses" className="inline-flex justify-center text-white bg-sky-600 hover:bg-sky-800 hover:px-5 px-3 py-2 rounded-lg font-medium text-center focus:ring-4 focus:outline-none">
                            Browse Courses
                            <svg className="rtl:rotate-180 w-3.5 h-3.5 ms-2 mt-1" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                                <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
                            </svg>
                        </a>  
                    </div>
                </div>
                <div className="grid grid-cols-2 space-x-2">
                    <div className="flex flex-col justify-center pr-14">
                        <h3 className="mb-2 text-md font-bold tracking-tighter hover:tracking-normal">Browse Institutes: Your Path to Excellence</h3>
                        <p className="mb-2 font-normal text-gray-700 tracking-tighter">Navigate through a spectrum of educational excellence on our "Browse Institutes" page. Explore a curated collection of institutes offering top-notch education across various fields. Whether you seek renowned universities, specialized academies, or skill-focused institutions, we've got you covered. Discover detailed profiles, faculty insights, and vibrant campus cultures. Your ideal learning environment awaits. Begin your quest for knowledge and excellence by exploring the finest institutes. Elevate your educational journey with the right foundation.</p>
                        <a href="/user/institutes" className="inline-flex justify-center text-white bg-sky-600 hover:bg-sky-800 hover:px-5 px-3 py-2 rounded-lg font-medium text-center focus:ring-4 focus:outline-none">
                            Browse Institutes
                            <svg className="rtl:rotate-180 w-3.5 h-3.5 ms-2 mt-1" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                                <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
                            </svg>
                        </a>  
                    </div>
                    <img src={College} className="rounded-xl"/>
                </div>
            </div>
        </div>
    );
}

export default Home;