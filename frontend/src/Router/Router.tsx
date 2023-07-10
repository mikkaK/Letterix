import { Route, Routes } from "react-router-dom";
import LoginPage from "../components/pages/LoginPage/LoginPage";
import PrivateRoute from "./PrivateRoute";
import UserTable from "../components/pages/UserPage/UserTable";
import UserPage from "../components/pages/UserPage/UserPage";
import CreateCoverLetter from "../components/pages/CoverLetterPage/CreateCoverLetterPage";
import GeneratedCoverLetterPage from "../components/pages/CoverLetterPage/GeneratedCoverLetterPage";
import HomePage from "../components/pages/HomePage";

/**
 * Router component renders a route switch with all available pages
 */

const Router = () => {
  //const { checkRole } = useContext(ActiveUserContext);

  /** navigate to different "home"-locations depending on Role the user have */

  return (
    <Routes>
      <Route path={"/"} element={<HomePage />} />
      <Route path={"/login"} element={<LoginPage />} />

      <Route
        path={"/users"}
        element={<PrivateRoute authorities={[]} element={<UserTable />} />}
      />
        <Route
            path={"/createCoverLetter"}
            element={<CreateCoverLetter/>}
        />
        <Route
            path={"/generatedCoverLetter/:chatGptResponse"}
            element={<GeneratedCoverLetterPage/>}
        />
      <Route
        path="/useredit"
        element={
          <PrivateRoute authorities={[]} element={<UserPage />}></PrivateRoute>
        }
      />
      <Route
        path="/useredit/:userId"
        element={
          <PrivateRoute authorities={[]} element={<UserPage />}></PrivateRoute>
        }
      />

      <Route path="*" element={<div>Not Found</div>} />
    </Routes>
  );
};

export default Router;
