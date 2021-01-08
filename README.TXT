# administration-service-java

PROJECT TITLE: Coursework- Reliable Administration and Translation Servise (RATS)
AUTHOR: Natallia Akuelnka
Technology: Java, BlueJ

The Reliable Administration and Translation Service (RATS) provide staff  to perform office and translation jobs 
for clients. Branches at different locations e.g. Watford, are responsible for accepting jobs from clients, 
maintaining information about jobs and maintaining information about staff, including wages.

A branch maintains a list of staff together with information on whether they are available for jobs. 
Each staff member has a unique identifier which consist of letters and digits e.g. TY333. 
There are three types of staff: typists, clerks and translators. 
Clerks can only work at the client's office (and not at home), and do not offer shorthand. 
Typists and translators may choose to work only at home 
(those that specify that they can be office based, can also work at home). 
Typists and translators may also offer shorthand. Typists should provide an email. 
Only translators can translate and must specify a foreign language.

Each staff  member at a branch has an availability status, which will be one of the following:
•	available  	(for jobs)
•	working        	(assigned to a job and unavailable for other jobs)
•	unavailable     	(for jobs e.g. on holiday, ill, busy etc.)

When a staff member is added to the branch, their availability status is "available".

The RATS system stores the following information about a job: a unique job number 
allocated sequentially starting from 100, the customer information, 
whether the job is to be done at home or on site, 
whether it requires shorthand and the language required. 
For jobs which do not require any translation work, the default language is "English".  
Customer information includes customer number, name and credit limit.
Regular customers have a credit limit of £500, while for others the limit is £100

A job submitted by a customer is added to a collection of jobs if the customer is 
not over their credit limit. At this point, the job can be allocated a member 
of staff immediately if there is a suitable person available. 
If a suitable staff member is available, the state of the job is set to "on going", 
the selected staff member is added to the job information, the staff member's state is 
set to "working" and a message giving the job number and staff allocated is returned. 
If a staff member is not available, job's state is set to "waiting" and 
a message containing the job number and  "Job waiting" returned.

When a job has been done, the state of the job is set to "done", 
the state of its staff member is set to "available" and the number of hours 
is used to calculate the cost of the job. Clerks are paid £8 per hour, 
Typists £12 per hour, while translators negotiate their own hourly rate. 
A job which requires shorthand has an added fee of £20. Cost of the job is 
added to the wages of the staff member and this cost plus a standard charge (currently £25) 
is added to the money owed by the customer.

