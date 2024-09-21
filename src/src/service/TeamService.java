package service;

import domian.Architect;
import domian.Designer;
import domian.Employee;
import domian.Programmer;

public class TeamService {
    private static int counter = 1;

    private final int MAX_MEMBER = 5;

    private Programmer[] programmers = new Programmer[MAX_MEMBER];

    private int total = 0;

    public Programmer[] getTeam(){
        Programmer[] output = new Programmer[total];
        for (int i = 0; i < total; i++) {
            output[i] = programmers[i];
        }
        return output;
    }

    public void addMember(Employee e) throws TeamException{

        if (total >= MAX_MEMBER)
            throw new TeamException("成员已满，无法添加");
        if (!(e instanceof Programmer))
            throw new TeamException("该成员不是开发人员，无法添加");

        Programmer p = (Programmer)e;
        switch (p.getStatus()) {
            case BUSY    :
                throw new TeamException("该员工已是某团队成员");
            case VOCATION:
                throw new TeamException("该员正在休假，无法添加");
        }

        if (isExist(p))
            throw new TeamException("该员工已在本团队中");

        int numOfArch = 0, numOfDsgn = 0, numOfPrg = 0;
        for (int i = 0; i < total; i++) {
            if (programmers[i] instanceof Architect) numOfArch++;
            else if (programmers[i] instanceof Designer) numOfDsgn++;
            else if (programmers[i] instanceof Programmer) numOfPrg++;
        }

        if (p instanceof Architect) {
            if (numOfArch >= 1) throw new TeamException("团队中至多只能有一名架构师");
        } else if (p instanceof Designer) {
            if (numOfDsgn >= 2) throw new TeamException("团队中至多只能有两名设计师");
        } else if (p instanceof Programmer) {
            if (numOfPrg >= 3) throw new TeamException("团队中至多只能有三名程序员");
        }
        //添加到数组
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        programmers[total++] = p;



    }

    private boolean isExist(Programmer p) {

        for (int i = 0; i < total; i++) {
            if(programmers[i].getId() == p.getId()){
                return true;
            }
        }
        return false;

    }

    public void removeMember(int memberId) throws TeamException {
        int n = 0;
        for (; n < total; n++) {
            if (programmers[n].getMemberId() == memberId) {
                programmers[n].setStatus(Status.FREE);
                break;
            }
        }
        if (n == total)
            throw new TeamException("找不到该成员，无法删除");
        for (int i = n + 1; i < total; i++) {
            programmers[i - 1] = programmers[i];
        }
        programmers[--total] = null;
    }

}
