INSERT INTO public.student(
	student_id, email, student_first_name, student_last_name)
	VALUES (1, 'jj@jj', 'f1', 'l1');

INSERT INTO public.student(
	student_id, email, student_first_name, student_last_name)
	VALUES (2, 'jj@jj2', 'f2', 'l2');

INSERT INTO public.student(
	student_id, email, student_first_name, student_last_name)
	VALUES (3, 'jj@jj3', 'f3', 'l3');


INSERT INTO public.course(
	courseid, coursecontent, student_student_id)
	VALUES (1, 'java', 1);