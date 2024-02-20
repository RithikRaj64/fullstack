function Navbar() {
    return (
        <nav className="bg-white border-indigo-200 dark:bg-indigo-900">
            <div className="max-w-screen-xl flex flex-wrap justify-between mx-auto p-4">
                <div className="hidden w-full md:block md:w-auto" id="navbar-default">
                    <ul className="font-medium flex flex-col p-4 md:p-0 mt-4 border border-indigo-100 rounded-lg bg-indigo-50 md:flex-row md:space-x-8 rtl:space-x-reverse md:mt-0 md:border-0 md:bg-white dark:bg-indigo-800 md:dark:bg-indigo-900 dark:border-indigo-700">
                        <li>
                            <a href="/user/home" className="block py-2 px-3 text-indigo-900 rounded hover:bg-indigo-100 md:hover:bg-transparent md:border-0 md:hover:text-orange-500 md:p-0 dark:text-white md:dark:hover:text-orange-500 dark:hover:bg-indigo-700 dark:hover:text-white md:dark:hover:bg-transparent">Home</a>
                        </li>
                        <li>
                            <a href="/user/about" className="block py-2 px-3 text-indigo-900 rounded hover:bg-indigo-100 md:hover:bg-transparent md:border-0 md:hover:text-orange-500 md:p-0 dark:text-white md:dark:hover:text-orange-500 dark:hover:bg-indigo-700 dark:hover:text-white md:dark:hover:bg-transparent">About</a>
                        </li>
                        <li>
                            <a href="/signin" className="block py-2 px-3 text-indigo-900 rounded hover:bg-indigo-100 md:hover:bg-transparent md:border-0 md:hover:text-orange-500 md:p-0 dark:text-white md:dark:hover:text-orange-500 dark:hover:bg-indigo-700 dark:hover:text-white md:dark:hover:bg-transparent">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}

export default Navbar