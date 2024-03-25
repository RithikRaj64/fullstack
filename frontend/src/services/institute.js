import instance from "./axios"

const api_url = "http://localhost:8080/api/v1";

// Profile
export const getInstId = (id) => instance.get(`${api_url}/user/getIns/${id}`)
export const getDetails = (id) => instance.get(`${api_url}/institute/get/${id}`);
export const updateDetails = (id, data) => instance.patch(`${api_url}/institute/updateDetails/${id}`, data);

// Course
export const addCourse = (data) => instance.post(`${api_url}/course/add`, data);
export const getAllCourse = () => instance.get(`${api_url}/course/get`);
export const getCourse = (id) => instance.get(`${api_url}/course/get/${id}`);
export const deleteCourse = (id) => instance.delete(`${api_url}/course/delete/${id}`);
export const getAllCourseInstitute = (id) => instance.get(`${api_url}/course/get/institute/${id}`);

// Application
export const accept = (id) => instance.patch(`${api_url}/application/accept/${id}`);
export const reject = (id) => instance.patch(`${api_url}/application/reject/${id}`);
export const paid = (id) => instance.patch(`${api_url}/application/paid/${id}`);