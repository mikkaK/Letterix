import {Button, FormControl, FormLabel, Grid, TextField, Box} from "@mui/material";
import { useFormik } from "formik";
import {CoverLetterModel} from "../../../types/models/CoverLetterModel.model";


export const initialCoverLetterValues: CoverLetterModel = {
    id: '',
    name: '',
    surname: '',
    age: '',
    appliedCompany: '',
    position: '',
    currentEducationLevel: '',
    skills: [],
    interests: [],
    weaknesses: [],
};

const CoverLetter = () => {
    const formik = useFormik({
        initialValues: initialCoverLetterValues,
        onSubmit: (values) => {
            // Handle form submission
            console.log(values);
        },
    });
    return (
        <Box sx={{ justifyContent: "center", marginLeft: 2, display: "block" }}>
        <form onSubmit={formik.handleSubmit}>
            <Grid container spacing={1}>
                <Grid xs={12}>
                    <h1>
                        Create cover letter
                    </h1>
                </Grid>
                <Grid xs={12}>
                    <FormControl>
                        <FormLabel>Enter name</FormLabel>
                        <TextField></TextField>
                    </FormControl>
                </Grid>
                <Grid xs={12}>
                    <FormControl>
                        <FormLabel>Enter surname</FormLabel>
                        <TextField></TextField>
                    </FormControl>
                </Grid>
                <Grid xs={12}>
                    <FormControl>
                        <FormLabel>Enter age</FormLabel>
                        <TextField
                            type="number"
                        ></TextField>
                    </FormControl>
                </Grid>
                <Grid xs={12}>
                    <FormControl>
                        <FormLabel>Enter company to apply to</FormLabel>
                        <TextField></TextField>
                    </FormControl>
                </Grid>
                <Grid xs={12}>
                    <FormControl>
                        <FormLabel>Enter position you're applying to</FormLabel>
                        <TextField></TextField>
                    </FormControl>
                </Grid>
                <Grid xs={12}>
                    <FormControl>
                        <FormLabel>Enter current education level</FormLabel>
                        <TextField></TextField>
                    </FormControl>
                </Grid>
                <Button>Submit</Button>
            </Grid>
        </form>
        </Box>
    );
};

export default CoverLetter;
